pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("com.android.application") version "8.5.1" // Or your AGP version
        id("org.jetbrains.kotlin.android") version "2.0.21" // Your Kotlin version
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" // NEW: Compose Compiler Plugin
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LOGIN"
include(":app")
 