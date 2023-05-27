package com.chatandpay.ws.configuration


import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.bson.UuidRepresentation
import org.bson.types.ObjectId
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.util.*


@Configuration
@EnableMongoRepositories(basePackages = ["com.chatandpay.ws.chat.repository"])
@ConfigurationProperties(prefix = "spring.data.mongodb")
class MongoConfig : AbstractMongoClientConfiguration() {

    lateinit var uri: String

    override fun getDatabaseName(): String {
        return "chatAndPay"
    }

    override fun customConversions(): MongoCustomConversions {
        return MongoCustomConversions(
            listOf(ObjectIdToUUIDConverter())
        )
    }

    class ObjectIdToUUIDConverter : Converter<ObjectId, UUID> {
        override fun convert(source: ObjectId): UUID {
            return UUID.fromString(source.toString())
        }
    }

    override fun mongoClient(): MongoClient {

        val connectionString = ConnectionString(uri)
        val mongoClientSettings = MongoClientSettings
            .builder()
            .uuidRepresentation(UuidRepresentation.STANDARD)
            .applyConnectionString(connectionString)
            .build()

        return MongoClients.create(mongoClientSettings)
    }



}
