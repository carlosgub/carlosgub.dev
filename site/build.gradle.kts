import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
}

group = "carlosgub.dev"
version = "1.0"

kobweb {
    app {
        index {
            description.set("Carlos Ugaz Website, Powered by Kobweb")
            head.add {
                link {
                    rel = "stylesheet"
                    href = "https://emoji-css.afeld.me/emoji.css"
                    type = "text/css"
                }
                link {
                    rel = "preconnect"
                    href = "https://fonts.googleapis.com"
                }
                link {
                    rel = "preconnect"
                    href = "https://fonts.gstatic.com"
                    attributes["crossorigin"] = ""
                }
                link {
                    rel = "stylesheet"
                    href = "https://fonts.googleapis.com/css2?family=Source+Sans+3:ital,wght@0,200..900;1,200..900&display=swap"
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("carlosgub.dev")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(libs.compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
                implementation(libs.kobweb.silk.icons.mdi)
            }
        }
    }
}
