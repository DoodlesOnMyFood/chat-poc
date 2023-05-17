plugins {
    id("java")
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    maven("https://packages.confluent.io/maven")
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("script-runtime"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.0.5")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.0")
    implementation(kotlin("gradle-plugin", version = "1.8.20")) // Kotlin Gradle Plugin
    implementation(kotlin("allopen", version = "1.8.20")) // Kotlin Spring Plugin
    implementation(kotlin("test", version = "1.8.20")) // Kotlin Spring Plugin
    implementation("nu.studer:gradle-jooq-plugin:8.1")
}
