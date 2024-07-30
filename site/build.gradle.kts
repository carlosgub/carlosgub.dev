import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script
import kotlinx.html.style
import kotlinx.html.unsafe

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
}

group = "carlosgub.dev"
version = "1.0"

kobweb {
    app {
        index {
            description.set("Carlos Ugaz Website, Powered by Kobweb")
            head.add {
                val bootstrapJs = routePrefix.prependTo("/bootstrap.js")
                script {
                    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
                    async = true
                }
                style {
                    unsafe {
                        raw("@import url(\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\") layer(bootstrapjs);")
                        raw("@import url(\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css\") layer(bootstrapjs);")
                    }
                }
                link{
                    rel = "stylesheet"
                    href = "/fonts/faces.css"
                    type = "text/css"
                }
            }
            excludeHtmlForDependencies.add("bootstrap")
        }
    }
}

kotlin {
    configAsKobwebApplication("carlosgub.dev")

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
    }
}
