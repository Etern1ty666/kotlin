plugins {
    // lets Gradle download the JDK it needs instead of you installing one
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "kotlin-lessons"
include("app")
