rootProject.name = "spring-library"

pluginManagement{
    val springDependencyVersion: String by settings
    val springBootVersion: String by settings
    val jvmVersion: String by settings

    plugins {
        kotlin("jvm") version jvmVersion
        kotlin("plugin.spring") version jvmVersion
        kotlin("plugin.jpa") version jvmVersion

        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyVersion
    }
}
