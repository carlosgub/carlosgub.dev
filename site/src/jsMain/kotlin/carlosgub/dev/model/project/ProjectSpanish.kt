package carlosgub.dev.model.project

import carlosgub.dev.model.Section

data object ProjectSpanish : ProjectSection {
    override val title: String = Section.Projects.englishText
    override val firstProject: Project = Project(
        stackList = piggyBankStack,
        name = "Piggy Bank",
        description = "Creé la aplicación PiggyBank para ofrecer una herramienta versátil que te " +
                "permita gestionar tus finanzas. Ya sea que quieras registrar tus gastos, anotar tus " +
                "ingresos o visualizar tus movimientos financieros a través de gráficos, esta app lo " +
                "tiene todo. Ofrece una interfaz fácil de usar y funcionalidades sólidas para ayudarte " +
                "a mantener el control de tus finanzas.",
        actionButtonText = actionButtonTextSpanish
    )
    override val secondProject: Project = Project(
        stackList = personalWebsiteStack,
        name = "Pagina personal",
        description = "Crear carlosgub.dev fue un viaje que combinó creatividad con precisión técnica, " +
                "impulsado completamente por Kotlin. El frontend fue desarrollado utilizando Kobweb " +
                "y Kotlin Multiplatform, un potente framework que integra Kotlin en el proceso de " +
                "desarrollo web, permitiendo la creación de interfaces dinámicas e interactivas. " +
                "Esta combinación ofreció una experiencia de desarrollo unificada, con todos los " +
                "componentes escritos en Kotlin.",
        actionButtonText = actionButtonTextSpanish
    )


}