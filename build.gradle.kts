plugins {
    java
    `maven-publish`
}

group = "crypto.r35157.nenjim"
version = "0.1.0-SNAPSHOT"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "24"
    targetCompatibility = "24"
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            url = uri(System.getProperty("user.home") + "/.m2/repository")
        }
    }
}
