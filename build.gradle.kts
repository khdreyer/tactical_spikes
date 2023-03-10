plugins {
    id("java")
    id("org.springframework.boot") version "2.7.9"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.google.guava:guava:31.1-jre")
    annotationProcessor("org.immutables:value:2.9.2")
    implementation("org.immutables:value:2.9.2")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-actuator-autoconfigure")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation("org.apache.commons:commons-lang3:3.12.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}