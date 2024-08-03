package carlosgub.dev.components.models

enum class Stack(
    val id: String
) {
    Android(
        id = "Android",
    ),
    IOS(
        id = "IOS",
    ),
    KMP(
        id = "Kotlin Multiplatform",
    ),
    Kotlin(
        id = "Kotlin",
    ),
    Java(
        id = "Java"
    ),
    JetpackCompose(
        id = "Jetpack Compose"
    ),
    LiveData(
        id = "LiveData"
    ),
    MVVM(
        id = "MVVM"
    ),
    Coroutines(
        id = "Coroutines"
    ),
    KotlinFlow(
        id = "Flow"
    ),
    Koin(
        id = "Koin"
    ),
    Dagger(
        id = "Dagger"
    ),
    Retrofit(
        id = "Retrofit"
    ),
    GraphQL(
        id = "GraphQL"
    ),
    Rx(
        id = "Rx Kotlin"
    )
}