import com.varabyte.kobweb.gradle.application.extensions.AppBlock
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.noScript
import kotlinx.html.script
import kotlinx.html.style

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
}

group = "carlosgub.dev"
version = "1.0"

kobweb {
    app {
        legacyRouteRedirectStrategy.set(AppBlock.LegacyRouteRedirectStrategy.DISALLOW)
        index {
            description.set("Powered by Kobweb")
            head.add {
                script {
                    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
                    async = true
                }
                link{
                    rel = "stylesheet"
                    href = "/fonts/faces.css"
                    type = "text/css"
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("dev", includeServer = true)

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kotlin.bootstrap)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(libs.kobweb.api)
            }
        }
    }
}
