package carlosgub.dev.model.aboutme

import carlosgub.dev.model.Section

data object AboutMeEnglish : AboutMeSection {
    override val title: String = Section.About.englishText
    override val firstParagraph: String = "Hello! I'm Carlos, a Senior Software Engineer, specializing in Mobile app " +
            "development and creating cross-platform solutions using Kotlin Multiplatform. " +
            "With eight years of experience, I've led teams in various industries including " +
            "banking, education, e-commerce, and media."
    override val secondParagraph: String =
        "I'm an person enthusiast who thrives on exploring emerging technologies and staying " +
                "at the cutting edge of the field. Let's collaborate to bring innovative " +
                "mobile solutions to life!"
    override val thirdParagraph: String =
        "If you're seeking a Senior Software Engineer with a deep passion for Mobile development, " +
                "a track record of leadership, and commitment to staying ahead of the curve, I'd love " +
                "to connect and discuss how I can bring my skills and enthusiasm to your next project."
}