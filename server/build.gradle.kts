import com.google.protobuf.gradle.id

buildscript {
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.9.2")
    }
}

plugins {
    id("project.kotlin-jooq")
    id("com.google.protobuf") version "0.9.2"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://packages.confluent.io/maven")
}
val jooqVersion = "3.18.3"

dependencies {
    implementation(platform("com.linecorp.armeria:armeria-bom:1.23.1"))
    implementation(platform("io.netty:netty-bom:4.1.91.Final"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.google.protobuf:protobuf-kotlin:3.21.1")
    implementation("io.r2dbc:r2dbc-pool:1.0.0.RELEASE")
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")
    implementation("com.linecorp.armeria:armeria-spring-boot3-webflux-starter:1.23.1")
    implementation("com.linecorp.armeria:armeria-grpc:1.23.1")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.postgresql:r2dbc-postgresql:1.0.1.RELEASE")
    implementation("io.confluent:kafka-protobuf-serializer:7.3.3")
    implementation("org.springframework.data:spring-data-r2dbc")
    implementation("io.github.microutils:kotlin-logging:3.0.5")
    implementation("org.jooq:jooq-meta:$jooqVersion")
    implementation("org.jooq:jooq-kotlin-coroutines:$jooqVersion")
    implementation("org.jooq:jooq-codegen-maven:$jooqVersion")
    jooqGenerator("org.postgresql:postgresql:42.6.0")
    testImplementation(kotlin("test"))
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.10.1"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.54.1"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}
tasks {
    jar {
        enabled = false
    }
    bootJar {
        exclude("application.yml")
    }
}
kotlin {
    jvmToolchain(17)
}
