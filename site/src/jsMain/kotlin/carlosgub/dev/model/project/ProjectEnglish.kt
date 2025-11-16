package carlosgub.dev.model.project

import carlosgub.dev.model.Section

data object ProjectEnglish : ProjectSection {
    override val title: String = Section.Projects.englishText
    override val firstProject: Project = Project(
        stackList = piggyBankStack,
        name = "Piggy Bank",
        description = "I created the PiggyBank App to have a versatile tool for manage your finances. Whether you want to track expenses," +
                " log incomes, or visualize your financial movements through charts, this app has got you covered. " +
                "It offers a user-friendly interface and robust functionalities to help you stay on top of your finances.",
        actionButtonText = actionButtonTextEnglish
    )
    override val secondProject: Project = Project(
        stackList = personalWebsiteStack,
        name = "Personal website",
        description = "Creating carlosgub.dev was a journey of blending creativity with technical precision, " +
                "entirely powered by Kotlin. The frontend was built using Kobweb and Kotlin Multiplatform, " +
                "a powerful framework that integrates Kotlin into the web development process, enabling the creation " +
                "of dynamic and interactive user interfaces. This combination allowed for a unified development experience, " +
                "with all components written in Kotlin.",
        actionButtonText = actionButtonTextEnglish
    )


}