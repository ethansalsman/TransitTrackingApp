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

        maven {
            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
            authentication {
                create<BasicAuthentication>("basic")
            }
            credentials {
                username = "mapbox"
                password = "sk.eyJ1IjoiZXRoc2FscyIsImEiOiJjbHVpbTJranYwNXF1Mm5vM2Vwajh0NDIzIn0.wiLUFqq1wfpFBaRXKQ_wRg"
            }
        }
        }
}

rootProject.name = "TransitTrackingApp"
include(":app")
 