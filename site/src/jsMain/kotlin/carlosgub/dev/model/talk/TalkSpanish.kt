package carlosgub.dev.model.talk

import carlosgub.dev.model.Section

data object TalkSpanish : TalkSection {
    override val title: String = Section.Talks.spanishText

    override val talks: List<Talk> = listOf(
        Talk(
            flag = "em-flag-pe",
            title = "klibs.io + IA – Cómo elegir librerías multiplataforma (caso PiggyBank)",
            slidePath = "/presentation/klibs-io-piggybank",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Android Dev Peru #61 – Cómo crear tu primera página web con Kobweb",
            slidePath = "/presentation/create-kobweb",
            videoPath = "https://youtu.be/avs8Zros4HI?t=65",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "GDG DevFest 2023 – Cómo implementar Firestore en Kotlin Multiplatform",
            slidePath = "/presentation/firestore-kmm",
            videoPath = "https://www.youtube.com/watch?v=tb5h2XXAq6A",
        ),
        Talk(
            flag = "em-flag-in",
            title = "ICOEI 2021 – Blockchain y contratos inteligentes para trazabilidad de donaciones",
            paperPath = "https://ieeexplore.ieee.org/document/9453016/"
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Perú #6 2020 – ML Kit Barcode con CameraX",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "GDG DevFest 2019 – AutoML Vision Edge",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Perú #5 2019 – Chat en tiempo real con Firestore",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Kotlin Everywhere Lima 2019 – Kotlin DSL",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Day 2019 – Chat en tiempo real con Firestore",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "GDG Open Meetup Mobile #2 2019 – AutoML Vision Edge",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "IO Extended Lima 2019 – Reconocimiento de objetos en tiempo real con ML Kit",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Perú #4 2019 – Firebase AutoML Vision Edge",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Perú #2 2019 – Firebase Analytics: Migrando de GA a FA",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Perú #1 2019 – Reconocimiento facial con ML Kit",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "GDG Lima 2018 – Android App Bundle y Dynamic Delivery",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Android Dev Perú Meetup #19 2018 – Reconocimiento facial con ML Kit",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Google I/O Extended 2018 – Creando una habitación inteligente con Android Things",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Android Dev Perú Meetup #18 2018 – Ejemplo práctico con Android Things",
        ),
    )
}
