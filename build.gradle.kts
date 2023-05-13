plugins {
    kotlin("jvm") version "1.8.20"
}

group = "com.local.labs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.21")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}