package carlosgub.dev.model.aboutme

import carlosgub.dev.model.Section

data object AboutMeSpanish : AboutMeSection {
    override val title: String = Section.About.spanishText
    override val firstParagraph: String = "¡Hola! Soy Carlos, Senior Software Engineer especializado " +
            "en desarrollo de aplicaciones móviles y en la creación de soluciones multiplataforma " +
            "usando Kotlin Multiplatform. Con ocho años de experiencia, he liderado equipos en " +
            "diversas industrias, como banca, educación, comercio electrónico y medios."
    override val secondParagraph: String = "Soy una persona entusiasta que disfruta explorar tecnologías " +
            "emergentes y mantenerse a la vanguardia del campo. ¡Colaboremos para dar vida a soluciones " +
            "móviles innovadoras!"
    override val thirdParagraph: String = "Si buscas un Senior Software Engineer con una profunda pasión " +
            "por el desarrollo móvil, experiencia comprobada en liderazgo y un compromiso por mantenerse " +
            "siempre un paso adelante, estaré encantado de conectar y conversar sobre cómo puedo aportar mis " +
            "habilidades y entusiasmo a tu próximo proyecto."
}