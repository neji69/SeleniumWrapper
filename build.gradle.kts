plugins {
    id("java")
    `java-library`
    id("io.qameta.allure") version "2.9.6"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(15))
    }
}

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_15}"
    targetCompatibility = "${JavaVersion.VERSION_15}"
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

group = "ru.neji69"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.junit.jupiter:junit-jupiter-api:5.8.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testRuntimeOnly("org.slf4j:slf4j-simple:1.7.36")

    testImplementation("org.assertj:assertj-core:3.22.0")

    testImplementation("org.seleniumhq.selenium:selenium-java:4.1.4")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.2.0")
    testImplementation("io.qameta.allure:allure-junit5:2.18.1")
}

allure {
    allure {
        version.set("2.17.1")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    systemProperty("junit.jupiter.extensions.autodetection.enabled", true)
    systemProperty("junit.jupiter.execution.parallel.enabled", true)
    systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "dynamic")
}