<!doctype html>
<html lang="en">
<head>
    <title>Websocket ChatRoom</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/dist/css/bootstrap.min.css">
    <style>
        [v-cloak] {
            display: none;
        }
    </style>
</head>
<body>
<div class="container" id="app" v-cloak>
    <div>
        <h2>{{room.name}}</h2>
    </div>
    <div class="input-group">
        <div class="input-group-prepend">
            <label class="input-group-text">내용</label>
        </div>
        <input type="text" class="form-control" v-model="message" v-on:keypress.enter="sendMessage">
        <div class="input-group-append">
            <button class="btn btn-primary" type="button" @click="sendMessage">보내기</button>
        </div>
    </div>
    <ul class="list-group">
        <li class="list-group-item" v-for="message in messages">
            {{message.senderName}} - {{message.message}} - {{new Date(message.createdAt)}}</a>
        </li>
    </ul>
    <div></div>
</div>
<!-- JavaScript -->
<script src="/webjars/vue/2.5.16/dist/vue.min.js"></script>
<script src="/webjars/axios/0.17.1/dist/axios.min.js"></script>
<script src="/webjars/sockjs-client/1.1.2/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/2.3.3-1/stomp.min.js"></script>
<script>
    //alert(document.title);
    // websocket & stomp initialize
    var sock = new SockJS("/ws/chat");
    var ws = Stomp.over(sock);
    var reconnect = 0;
    // vue.js
    var vm = new Vue({
        el: '#app',
        data: {
            roomId: '',
            type: '',
            room: {},
            senderName: '',
            message: '',
            messages: []
        },
        created() {
            this.roomId = localStorage.getItem('wschat.roomId');
            this.type = localStorage.getItem('wschat.type');
            this.senderName = localStorage.getItem('wschat.sender');
            this.findRoom();
        },
        methods: {
            findRoom: function () {
                axios.get('/api/v1/chat/room/' + this.roomId).then(response => {
                    this.room = response.data;
                });
            },
            sendMessage: function () {

                if(this.type === "GROUP"){
                    ws.send("/pub/chat/room/" + this.roomId + "/type/group", {}, JSON.stringify({
                        type: 'COMMENT',
                        senderName: this.senderName,
                        message: this.message
                    }));
                }else{
                    ws.send("/pub/chat/room/" + this.roomId , {}, JSON.stringify({
                        type: 'COMMENT',
                        senderName: this.senderName,
                        message: this.message
                    }));
                }

                this.message = '';
            },
            recvMessage: function (recvList) {
                //if (recv.type === 'COMMENT') {
                recvList.map(recv => {
                    this.messages.unshift({
                        "type": recv.type,
                        "senderName": recv.senderName,
                        "message": recv.message,
                        "createdAt": recv.createdAt
                    })
                    console.log(this.messages);

                })
                //}
            }
        }
    });

    function connect() {
        // pub/sub event
        ws.connect({}, function (frame) {
            ws.subscribe("/sub/chat/room/" + vm.$data.roomId, function (message) {
                var recv = JSON.parse(message.body);
                console.log(recv);
                vm.recvMessage(recv);
            });

            ws.subscribe("/sub/chat/room/" + vm.$data.roomId + "/type/group", function (message) {
                var recv = JSON.parse(message.body);
                console.log(recv);
                vm.recvMessage(recv);
            });


            ws.send("/pub/chat/room/" + vm.$data.roomId, {}, JSON.stringify({
                type: 'ENTER',
                senderName: vm.$data.senderName,
                message: ''
            }));

        }, function (error) {
            if (reconnect++ <= 5) {
                setTimeout(function () {
                    console.log("connection reconnect");
                    sock = new SockJS("/ws/chat");
                    ws = Stomp.over(sock);
                    connect();
                }, 10 * 1000);
            }
        });
    }

    connect();
</script>
</body>
</html>
