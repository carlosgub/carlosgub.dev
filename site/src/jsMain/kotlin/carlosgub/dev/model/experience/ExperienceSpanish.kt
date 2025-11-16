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
            description = "En mi rol actual en Globant, he tenido el privilegio de desempeñarme como " +
                    "Senior Android Developer para clientes de gran renombre, incluyendo Yape, " +
                    "Ticketmaster, RedLink y actualmente Prisma. En Yape, he participado en el mantenimiento " +
                    "y la mejora continua de su aplicación, además de contribuir al desarrollo de una " +
                    "nueva versión. En Ticketmaster, desempeñé un papel fundamental en el mantenimiento " +
                    "de su aplicación, con un enfoque especial en funcionalidades integradas en aplicaciones " +
                    "de otras compañías, como la NFL y la NBA. Además, mi trabajo con RedLink y ahora con " +
                    "Prisma me ha permitido colaborar en soluciones financieras y de pagos de núcleo, " +
                    "apoyando la modernización, seguridad y escalabilidad de sus plataformas móviles. Esta " +
                    "amplia experiencia me ha permitido trabajar en proyectos diversos y desafiantes, " +
                    "asegurando siempre la más alta calidad para nuestros clientes.",
            stackList = rappiStack
        )

    override val seeResume: String = "Ver currículum completo "

    override val resumeHref: String = "/resume_esp.pdf"
}