package com.gabo.solidar.data

import PostModel
import com.gabo.solidar.domain.type.AssistanceArea

enum class MockPosts(
    val author: String,
    val date: String,
    val title: String,
    val description: String,
    val organization: String,
    val profilePicture: String,
    val following: Boolean,
    val likes: Long,
    val comments: Long,
    val shared: Long,
    val pictures: String,
    val assistanceArea: AssistanceArea,
) {
    GREENPEACE(
        author = "Greenpeace",
        date = "2025-07-01",
        title = "ballena 🐋💪",
        description =
            "🐳 Hace 50 años, activistas de Greenpeace se interpusieron entre un arpón y una ballena. No evitaron la matanza, pero lograron algo enorme: que el mundo lo viera.\n" +
                "Y así nació una nueva conciencia 🙌\n" +
                "Este solo fue el comienzo de una larga lucha que sigue viva en nuestra historia, pero que hoy continúa gracias a miles de personas que lo hacen posible 💙",
        organization = "Animales",
        profilePicture = "https://scontent.faep4-3.fna.fbcdn.net/v/t39.30808-1/515447135_1147531850734910_888089704259670235_n.jpg?stp=dst-jpg_s160x160_tt6&_nc_cat=106&ccb=1-7&_nc_sid=2d3e12&_nc_ohc=TKKW_AwQ1coQ7kNvwHPPLwc&_nc_oc=AdnC7me3q8099dhAV1Pl2m4-NyK4qXTWkDF6D7mopM-gSEQoMwiUuCRTJJ8j9QD7QlsiH6Ryl9mjldm7b2v_bjoD&_nc_zt=24&_nc_ht=scontent.faep4-3.fna&_nc_gid=5qJ0MOgF7ucwxflffmj6nA&oh=00_AfNQgPJdIL-bj6ORcgf7AxjGKm8UDOn576TlyZbxQE28bQ&oe=686A69B2",
        following = true,
        likes = 10,
        comments = 2,
        shared = 3,
        pictures = "https://www.fundacionaquae.org/wp-content/uploads/2019/09/ballena.jpg",
        assistanceArea = AssistanceArea.ANIMALS,
    ),

    PAULA_RIVERO(
        author = "Paula Rivero",
        date = "2025-06-30",
        title = "Primera vez enseñando 💛",
        description =
            "Nunca había dado clases, pero me animé a sumarme al taller de apoyo escolar.\n" +
                "Ver cómo se iluminaban los ojos de los chicos cuando entendían algo fue simplemente mágico. Gracias @EducandoJuntos por esta oportunidad 💫",
        organization = "Educando Juntos",
        profilePicture = "https://randomuser.me/api/portraits/women/65.jpg",
        following = false,
        likes = 14,
        comments = 3,
        shared = 2,
        pictures = "https://www.ademys.org.ar/v2/wp-content/uploads/2020/07/aula-vacia-3.jpg",
        assistanceArea = AssistanceArea.HUMAN_RIGHTS,
    ),

    HOSPITAL_DEL_SUR(
        author = "Hospital del Sur",
        date = "2025-06-29",
        title = "Sangre que salva vidas ❤️",
        description =
            "En la última jornada recolectamos más de 150 donaciones de sangre.\n" +
                "Gracias a cada persona que se acercó, hoy hay pacientes que tienen otra oportunidad. Sigamos donando, sigamos viviendo juntos 🩸",
        organization = "Vida en Sangre",
        profilePicture = "https://www.argentina.gob.ar/sites/default/files/gotita_recordatorio.png",
        following = true,
        likes = 23,
        comments = 4,
        shared = 7,
        pictures = "https://ipsst.gov.ar/wordpress/wp-content/uploads/2023/06/donacion-sangre.jpg",
        assistanceArea = AssistanceArea.PEOPLE,
    ),

    RAFAEL_MONTIEL(
        author = "Rafael Montiel",
        date = "2025-06-28",
        title = "Un refugio para ellos 🐶",
        description =
            "Cuando conocí el refugio, no podía creer la cantidad de animales abandonados.\n" +
                "Ahora vengo todos los sábados. Adoptar es importante, pero también lo es estar. Gracias @HuellitasDelSur 🐾",
        organization = "Huellitas del Sur",
        profilePicture = "https://randomuser.me/api/portraits/men/83.jpg",
        following = false,
        likes = 19,
        comments = 6,
        shared = 4,
        pictures = "https://i.ytimg.com/vi/LmjDD9zqfuo/maxresdefault.jpg?sqp=-oaymwEmCIAKENAF8quKqQMa8AEB-AH-DoACuAiKAgwIABABGGUgTShHMA8=&rs=AOn4CLBOjLWim0iERSnaXugM93i5BCHLjA",
        assistanceArea = AssistanceArea.ANIMALS,
    ),

    FUNDACION_ALIMENTO_DIGNO(
        author = "Fundación Alimento Digno",
        date = "2025-06-27",
        title = "Cocina con propósito 🥗",
        description =
            "En el taller de cocina aprendemos recetas económicas, pero también compartimos historias.\n" +
                "Cada clase termina con una sonrisa (¡y un plato lleno!). Gracias a quienes hacen esto posible 🙏",
        organization = "Comer Bien",
        profilePicture = "https://cdn-v1.udocz-assets.com/uploads/book/cover/736893/736893.jpg",
        following = true,
        likes = 17,
        comments = 5,
        shared = 6,
        pictures = "https://revista360grados.com.mx/wp-content/uploads/2023/04/comer-sano.jpeg",
        assistanceArea = AssistanceArea.HUMANITARIAN_AID,
    ),

    ISABEL_MORA(
        author = "Isabel Mora",
        date = "2025-06-26",
        title = "Después de la tormenta 🌧️🤝",
        description =
            "Nunca pensé que estaría llenando bolsas de arena y distribuyendo agua en medio de una inundación.\n" +
                "Pero lo hice. Y no estuve sola. Gracias @RescateSolidario por enseñarnos que todos podemos ayudar, aún en el caos.",
        organization = "Rescate Solidario",
        profilePicture = "https://randomuser.me/api/portraits/women/48.jpg",
        following = true,
        likes = 30,
        comments = 7,
        shared = 10,
        pictures = "https://www.lanacion.com.ar/resizer/v2/temporal-e-inundacion-en-bahia-blanca-avenida-X7U4VWLF4REZXMY6PORN4UARYI.JPG?auth=0d8cf75d2437754e498c884c6dd56b408e3a0ae80baeabf8c1eee7cdb6cff142&width=420&height=280&quality=70&smart=true",
        assistanceArea = AssistanceArea.HUMANITARIAN_AID,
    ),
    VALENTINA_DIAZ(
        author = "Valentina Díaz",
        date = "2025-06-25",
        title = "Una plaza más verde 🌱",
        description =
            "Fuimos con mis amigas a plantar árboles en una plaza que estaba muy descuidada. Al principio nadie se acercaba, pero al rato los vecinos salieron a ayudarnos 🪴\n" +
                "Fue hermoso ver cómo el barrio se unía por algo tan simple pero tan necesario.",
        organization = "Reverdecer",
        profilePicture = "https://randomuser.me/api/portraits/women/72.jpg",
        following = false,
        likes = 21,
        comments = 4,
        shared = 3,
        pictures = "https://phantom-elmundo.uecdn.es/e78a8e4aa3b06fb0c0473c7b9fcac43c/crop/1x0/1280x853/resize/828/f/jpg/assets/multimedia/imagenes/2025/03/03/17410151982347.jpg",
        assistanceArea = AssistanceArea.CLIMATE_CHANGE,
    ),

    ONG_NIUNNINOMAS(
        author = "Ni Una Niña Menos",
        date = "2025-06-24",
        title = "Charlas en escuelas 💜",
        description =
            "Dimos talleres sobre prevención de violencia de género en dos secundarias. Muchas chicas se animaron a hablar por primera vez. Nos abrazamos, lloramos, sanamos.\n" +
                "Gracias a las docentes que abrieron las puertas y a las estudiantes que se animaron a romper el silencio.",
        organization = "Derechos Humanos",
        profilePicture = "https://cdn-icons-png.flaticon.com/512/3062/3062634.png",
        following = false,
        likes = 42,
        comments = 11,
        shared = 9,
        pictures = "https://storage.googleapis.com/bucket-diarioactualidad/2023/06/c4c89567-ni-una-menos.jpg",
        assistanceArea = AssistanceArea.HUMAN_RIGHTS,
    ),

    MATIAS_FONSECA(
        author = "Matías Fonseca",
        date = "2025-06-23",
        title = "Una frazada, una sonrisa 🧣",
        description =
            "Salimos una noche fría con un grupo de voluntarios a repartir ropa de abrigo. Nos cruzamos con un hombre que solo pidió una charla.\n" +
                "Ese encuentro me cambió la forma de ver la calle. A veces dar tu tiempo vale más que una manta.",
        organization = "Abrigo en Movimiento",
        profilePicture = "https://randomuser.me/api/portraits/men/54.jpg",
        following = false,
        likes = 33,
        comments = 6,
        shared = 5,
        pictures = "https://i0.wp.com/www.lanoticiaweb.com.ar/wp-content/uploads/2025/07/Sin-titulo-1.png?resize=466%2C308&ssl=1",
        assistanceArea = AssistanceArea.HUMANITARIAN_AID,
    ),

    ONG_LEE_CONMIGO(
        author = "Lee Conmigo",
        date = "2025-06-22",
        title = "Lecturas que unen 📖",
        description =
            "En nuestro espacio de lectura compartimos cuentos con niños y niñas cada sábado. Pero lo que más disfrutan es cuando les preguntamos qué opinan, qué sienten, qué imaginan.\n" +
                "El libro es solo la excusa. Lo importante es el vínculo que creamos juntos.",
        organization = "Personas",
        profilePicture = "https://cdn-icons-png.flaticon.com/512/3469/3469265.png",
        following = false,
        likes = 18,
        comments = 2,
        shared = 2,
        pictures = "https://www.comunidadbaratz.com/wp-content/uploads/En-el-mundo-existen-150.000.000-de-libros%E2%80%A6-y-estos-son-los-100-mejores.jpg",
        assistanceArea = AssistanceArea.PEOPLE,
    ),

    AGUSTINA_BARRIOS(
        author = "Agustina Barrios",
        date = "2025-06-21",
        title = "Risas en el geriátrico 🎨",
        description =
            "Llevé pinturas y juegos de mesa a un hogar de personas mayores. Al principio estaban tímidos, pero terminamos bailando folclore.\n" +
                "Me fui con el corazón lleno y una invitación a volver todos los domingos ❤️",
        organization = "Red Mayor",
        profilePicture = "https://randomuser.me/api/portraits/women/90.jpg",
        following = false,
        likes = 25,
        comments = 8,
        shared = 4,
        pictures = "https://geriatricos.portalgeriatrico.com.ar/wp-content/uploads/2019/11/WhatsApp-Image-2020-06-10-at-11.13.55-3.jpeg",
        assistanceArea = AssistanceArea.PEOPLE,
    ),
    ;

    fun toPostModel() =
        PostModel(
            id = name,
            author = author,
            date = date,
            title = title,
            description = description,
            organization = organization,
            profilePicture = profilePicture,
            following = following,
            likes = likes,
            comments = comments,
            shared = shared,
            pictures = pictures,
            assistanceArea = assistanceArea,
        )
}
