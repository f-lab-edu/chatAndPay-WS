import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.11"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("com.google.cloud.tools.jib") version "3.1.2"
	id("org.flywaydb.flyway") version "8.0.3"

	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}


group = "com.chatandpay"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-websocket")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.postgresql:postgresql:42.2.23")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

//	testImplementation("org.springframework.security:spring-security-test")


	implementation("org.springframework.boot:spring-boot-starter-freemarker")
	implementation("org.webjars.bower:bootstrap:4.3.1")
	implementation("org.webjars.bower:vue:2.5.16")
	implementation("org.webjars.bower:axios:0.17.1")
	implementation("org.webjars:sockjs-client:1.1.2")
	implementation("org.webjars:stomp-websocket:2.3.3-1")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-commandline:8.0.3")

//
//	implementation("com.fasterxml.uuid:java-uuid-generator:3.2.0")

	implementation("org.springframework.boot:spring-boot-devtools:2.6.3")
	implementation("javax.validation:validation-api:2.0.1.Final")


}

jib {
	from {
		image = "openjdk:17-jdk-alpine"
	}
	to {
		image = "ankyeongeun/chat-and-pay:chat"
	}
	container {
		jvmFlags = listOf("-Xms512m", "-Xmx512m")
	}

}

flyway {
	url = "jdbc:postgresql://localhost:5432/chat"
	user = "chat"
	password = "chat"
}



tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

