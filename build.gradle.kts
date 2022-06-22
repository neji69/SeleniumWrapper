plugins {
    id("java")
}

group = "ru.neji69"
version = "1.0-SNAPSHOT"

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

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    systemProperty("junit.jupiter.extensions.autodetection.enabled", true)
}