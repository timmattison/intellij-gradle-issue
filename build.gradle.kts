plugins {
    kotlin("jvm") version "1.4.10"

    // Creates fat JAR
    id("com.github.johnrengelman.shadow") version "6.0.0"

    id("java")
}

// Toolchain and language version both report errors but work in the build
java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

val gradleDependencyVersion = "6.7"

tasks.wrapper {
    gradleVersion = gradleDependencyVersion
    distributionType = Wrapper.DistributionType.ALL
}

repositories {
    mavenCentral()
}

tasks.register("temp", {
    println("Test")
})

tasks.shadowJar {
    // Just to show that dependsOn shows as an error as well
    dependsOn += tasks.get("temp")
}