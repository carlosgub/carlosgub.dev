package carlosgub.dev.model.experience

import carlosgub.dev.model.Section

data object ExperienceSpanish : ExperienceSection {
    override val title: String = Section.Experience.spanishText
    override val firstWork: Company
        get() = Company(
            name = globant,
            url = globantUrl,
            time = "2022 - Presente",
            description = "En mi rol actual en Globant, he tenido el privilegio de desempeñarme como " +
                    "Senior Android Developer para clientes de gran renombre, como Yape y Ticketmaster. " +
                    "En Yape, he participado en el mantenimiento y la mejora continua de su aplicación, " +
                    "además de colaborar en el desarrollo de una nueva versión. Asimismo, en Ticketmaster " +
                    "desempeñé un papel fundamental en el mantenimiento de su aplicación, con un enfoque " +
                    "especial en las funcionalidades integradas en las aplicaciones de otras compañías, " +
                    "como la NFL y la NBA. Esta doble experiencia me ha permitido trabajar en " +
                    "proyectos diversos y desafiantes, garantizando siempre la más alta calidad " +
                    "para nuestros clientes.",
            stackList = globantStack
        )
    override val secondWork: Company
        get() = Company(
            name = rappi,
            url = rappiUrl,
            time = rappiTime,
            description = "Como Android Developer Tech Lead, mis responsabilidades incluían " +
                    "implementar nuevas funcionalidades y mejoras en las pantallas de búsqueda dentro " +
                    "de la aplicación, lo que generó un aumento significativo de ingresos de 1.5 millones " +
                    "de dólares mensuales. Lideré la implementación de una arquitectura modular para el motor " +
                    "de búsqueda, promoviendo una mayor escalabilidad y mantenibilidad. La colaboración con " +
                    "el equipo de desarrollo y el gerente del área fue fundamental para asegurar la sinergia " +
                    "del proyecto, y también estuve a cargo de los esfuerzos de rediseño de pantallas. A " +
                    "lo largo de este rol, utilicé herramientas y tecnologías como Kotlin, MVVM y RxKotlin " +
                    "para lograr estos objetivos.",
            stackList = rappiStack
        )

    override val seeResume: String = "Ver currículum completo "

    override val resumeHref: String = "/resume.pdf"
}