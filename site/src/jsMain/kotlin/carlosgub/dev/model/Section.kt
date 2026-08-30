package carlosgub.dev.model

enum class Section(
    val id: String,
    val englishText: String,
    val spanishText: String,
) {
    Home(
        id = "home",
        englishText = "Home",
        spanishText = "Inicio"
    ),
    About(
        id = "about",
        englishText = "About me",
        spanishText = "Sobre mi"
    ),
    Projects(
        id = "projects",
        englishText = "Personal Projects",
        spanishText = "Projectos Personales"
    ),
    Experience(
        id = "experience",
        englishText = "Experience",
        spanishText = "Experiencia"
    ),
    Talks(
        id = "talks",
        englishText = "Talks",
        spanishText = "Charlas"
    ),
    Posts(
        id = "posts",
        englishText = "Blog",
        spanishText = "Blog"
    ),
    ContactMe(
        id = "contact",
        englishText = "Contact Me",
        spanishText = "Contáctame"
    ), ;

    fun getText(language: Language): String =
        if (language == Language.English) englishText else spanishText

}