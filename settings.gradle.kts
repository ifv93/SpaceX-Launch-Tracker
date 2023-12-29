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
    }
}

rootProject.name = "SpaceX"
include(":app")
include(":core:api")
include(":core:data")
include(":core:common")
include(":feature:past_launches")
include(":feature:upcoming_launches")
include(":feature:launch_card")
