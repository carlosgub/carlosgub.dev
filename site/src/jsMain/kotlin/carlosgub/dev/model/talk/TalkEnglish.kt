package carlosgub.dev.model.talk

import carlosgub.dev.model.Section

data object TalkEnglish : TalkSection {
    override val title: String = Section.Talks.englishText

    override val talks: List<Talk> = listOf(
        Talk(
            flag = "em-flag-pe",
            title = "klibs.io + AI - How to choose multiplatform libraries (PiggyBank case study)",
            slidePath = "/presentation/klibs-io-piggybank",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Android Dev Peru #61 - How to create your first website w/ Kobweb",
            slidePath = "/presentation/create-kobweb",
            videoPath = "https://youtu.be/avs8Zros4HI?t=65",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "GDG DevFest 2023 - How to implement Firestore in Kotlin Multiplatform",
            slidePath = "/presentation/firestore-kmm",
            videoPath = "https://www.youtube.com/watch?v=tb5h2XXAq6A",
        ),
        Talk(
            flag = "em-flag-in",
            title = "2021 5th ICOEI - Blockchain and smart contract for donation traceability",
            paperPath = "https://ieeexplore.ieee.org/document/9453016/"
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Peru #6 2020 - Firebase ML Kit Barcode w/ CameraX",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "GDG DevFest 2019 - AutoML Vision Edge",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Peru #5 2019 - Realtime chat with Firestore",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Kotlin Everywhere Lima 2019 - Kotlin DSL",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Day 2019 - Realtime chat with Firestore",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "GDG Open MeetupMobile #2 2019 - AutoML Vision Edge",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "IO Extended Lima 2019 - Real-time object recognition with MLKit",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Peru #4 2019 - Firebase AutoML Vision Edge",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Peru #2 2019 - Firebase Analytics: Migrating from GA to FA",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Firebase Peru #1 2019 - Facial recognition with ML Kit",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "GDG Lima 2018 - Android App Bundle Dynamic Delivery",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Android Dev Peru Meetup #19 2018 - Facial recognition with ML Kit",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Google I/O Extended 2018 - Creating a smart room with Android Things",
        ),
        Talk(
            flag = "em-flag-pe",
            title = "Android Dev Peru Meetup #18 2018 - Android Things Example",
        ),
    )
}
