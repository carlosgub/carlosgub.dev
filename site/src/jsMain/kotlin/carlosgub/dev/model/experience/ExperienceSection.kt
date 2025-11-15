package carlosgub.dev.model.experience

interface ExperienceSection {
    val title: String
    val firstWork: Company
    val secondWork: Company
    val seeResume: String
    val resumeHref: String
}