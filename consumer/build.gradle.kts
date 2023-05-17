import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("project.kotlin-jooq")
    id("com.google.protobuf") version "0.9.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories { // Shared
    mavenCentral()
    maven("https://packages.confluent.io/maven")
}
val jooqVersion = "3.18.3" // Shared

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.google.protobuf:protobuf-kotlin:3.21.1")
    implementation("io.r2dbc:r2dbc-pool:1.0.0.RELEASE")
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
