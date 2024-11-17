plugins {
    kotlin("jvm") version "1.9.23"
    application
    id("com.gradleup.shadow") version "8.3.1"
}

group = "org.example"
version = "1.0-DEV"

repositories {
    mavenCentral()
    maven(url = "https://m2.dv8tion.net/releases")
    maven(url = "https://jitpack.io")
    maven(url = "https://maven.lavalink.dev/releases")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("net.dv8tion:JDA:5.2.1")
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.0")
    implementation("dev.arbjerg:lavaplayer:2.2.2")
    implementation("dev.lavalink.youtube:v2:1.8.3")
    implementation("ch.qos.logback:logback-classic:1.5.6")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}