package carlosgub.dev.model.experience

import carlosgub.dev.model.Section

data object ExperienceEnglish : ExperienceSection {
    override val title: String = Section.Experience.englishText

    override val firstWork: Company
        get() = Company(
            name = globant,
            url = globantUrl,
            time = "2022 - PRESENT",
            description = "In my current role at Globant, I have had the privilege of serving as a Senior " +
                    "Android Developer for esteemed clients, including Yape, Ticketmaster, RedLink, " +
                    "and currently Prisma. For Yape, I have been involved in maintaining and enhancing their " +
                    "application, while also contributing to the development of a new version. For Ticketmaster, " +
                    "I played a pivotal role in maintaining their application, particularly focusing on " +
                    "functionalities integrated into other companies' apps such as NFL and NBA. Additionally, " +
                    "my work with RedLink and now Prisma has allowed me to collaborate on core financial and " +
                    "payment solutions, supporting the modernization, security, and scalability of their " +
                    "mobile platforms. This broad experience has enabled me to work on diverse and challenging " +
                    "projects, always ensuring the highest quality for our clients.",
            stackList = globantStack
        )

    override val secondWork: Company
        get() = Company(
            name = rappi,
            url = rappiUrl,
            time = rappiTime,
            description = "As an Android Developer Tech Lead, my responsibilities included " +
                    "implementing new functionalities and enhancements to the search screens within the application, " +
                    "resulting in a substantial revenue increase of 1.5 million dollars per month. I spearheaded the " +
                    "implementation of a modular architecture for the search engine, fostering greater scalability and " +
                    "maintainability. Collaboration with the development team and area manager was integral to ensure project" +
                    " synergy, and I also led screen redesign efforts. Throughout this role, I harnessed tools and technologies" +
                    " such as Kotlin, MVVM, and Rx Kotlin to achieve these objectives.",
            stackList = rappiStack
        )

    override val seeResume: String= "View Full Resume "

    override val resumeHref: String = "/resume.pdf"
}