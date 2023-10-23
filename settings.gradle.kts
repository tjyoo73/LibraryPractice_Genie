pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //maven { url "https://jitpack.io" }
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "LibraryPractice_Genie"
include(":app")
