<!doctype html>
<html lang="en">
<head>
    <title>Websocket Chat</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/dist/css/bootstrap.min.css">
    <style>
        [v-cloak] {
            display: none;
        }
    </style>
</head>
<body>
<div class="container" id="app" v-cloak>
    <div class="row">
        <div class="col-md-12">
            <h3>채팅방 리스트</h3>
        </div>
    </div>
    <div>
        <div class="input-group">
            <div class="input-group-prepend">
                <label class="input-group-text">채팅 유형</label>
            </div>
            <select class="form-control" v-model="room_type">
                <option value="">선택하세요</option>
                <option value="GROUP">그룹 채팅</option>
                <option value="ONE_TO_ONE">일반 채팅</option>
            </select>
        </div>
    <div class="input-group">
        <div class="input-group-prepend">
            <label class="input-group-text">방제목</label>
        </div>
        <input type="text" class="form-control" v-model="room_name" @keyup.enter="createRoom">
        <div class="input-group-append">
            <button class="btn btn-primary" type="button" @click="createRoom">채팅방 개설</button>
        </div>
    </div>
    <ul class="list-group">
        <li class="list-group-item list-group-item-action" v-for="item in chatrooms" v-bind:key="item.id"
            v-on:click="enterRoom(item.id)">
            {{item.name}}
        </li>
    </ul>
</div>
<!-- JavaScript -->
<script src="/webjars/vue/2.5.16/dist/vue.min.js"></script>
<script src="/webjars/axios/0.17.1/dist/axios.min.js"></script>
<script src="/webjars/bootstrap/4.3.1/dist/js/bootstrap.min.js"></script>
<script src="/webjars/sockjs-client/1.1.2/sockjs.min.js"></script>
<script>
    var vm = new Vue({
        el: '#app',
        data: {
            room_name: '',
            room_type: '',
            chatrooms: []
        },
        created() {
            this.findAllRoom();
        },
        methods: {
            findAllRoom: function () {
                axios.get('/api/v1/chat/room').then(response => {
                    console.log(response.data)
                    this.chatrooms = response.data;
                });
            },
            createRoom: function () {
                  if (this.room_type === '') {
                    alert("채팅 유형을 선택해 주세요.");
                    return;
                  } else if (this.room_name === '') {
                    alert("방 제목을 입력해 주세요.");
                    return;
                  }else {

                    const data = {
                        name: this.room_name,
                        type: this.room_type
                    };

                    let url = '/api/v1/chat/room';

                    if (this.room_type === 'GROUP') {
                      url = '/api/v1/chat/room/type/group'; // GROUP일 경우 다른 API 호출
                      let members = ['647c33f22d1fc974ebf36c8a', '647c33f22d1fc974ebf36c8b', '647c33f22d1fc974ebf36c8c']; // ObjectId 리스트를 생성
                      data.members = members;
                    }

                    axios.post(url, data)
                        .then(
                            response => {
                                alert(response.data.name + "방 개설에 성공하였습니다.")
                                this.room_name = '';
                                this.findAllRoom();
                            }
                        )
                        .catch(response => {
                            alert("채팅방 개설에 실패하였습니다.");
                        });
                }
            },
            enterRoom: function (roomId) {
                var sender = prompt('대화명을 입력해 주세요.');
                if (sender && sender.trim() !== '') { // 대화명이 입력되었는지 확인
                    localStorage.setItem('wschat.sender', sender);
                    localStorage.setItem('wschat.roomId', roomId);
                    location.href = "/chat/room/" + roomId;
                }
            }
        }
    });
</script>
</body>
</html>
