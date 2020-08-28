import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
}
group = "aespiral"
version = "0.1"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val kotest_version = "4.2.1"
dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:$kotest_version") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:$kotest_version") // for kotest core jvm assertions
    testImplementation("io.kotest:kotest-property:$kotest_version") // for kotest property test
}