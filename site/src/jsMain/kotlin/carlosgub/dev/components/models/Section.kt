package carlosgub.dev.components.models

enum class Section(
    val id: String,
    val text:String,
) {
    Home(
        id = "home",
        text=  "Home"
    ),
    About(
        id = "about",
        text = "About me"
    ),
    Projects(
        id = "projects",
        text = "Personal Projects"
    ),
    Experience(
        id = "experience",
        text = "My Experience"
    ),
    Talks(
        id = "talks",
        text = "Talks"
    ),
    ContactMe(
        id = "contact",
        text = "Contact Me"
    ),
}