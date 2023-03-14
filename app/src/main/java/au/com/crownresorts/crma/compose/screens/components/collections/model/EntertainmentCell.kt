package au.com.crownresorts.crma.compose.screens.components.collections.model

data class EntertainmentCell(
    val id: Int,
    val urlImage: String,
    val title: String,
    val body: String
)

val cellList = listOf<EntertainmentCell>(
    EntertainmentCell(
        id = 1,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "one"
    ),    EntertainmentCell(
        id = 2,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "two"
    ),    EntertainmentCell(
        id = 3,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "three"
    ),    EntertainmentCell(
        id = 4,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "four"
    ),    EntertainmentCell(
        id = 5,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "five"
    ),    EntertainmentCell(
        id = 6,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "six"
    ),    EntertainmentCell(
        id = 7,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "seven"
    ),    EntertainmentCell(
        id = 8,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "eight"
    ),    EntertainmentCell(
        id = 9,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "nine"
    ),    EntertainmentCell(
        id = 10,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "ten"
    ),    EntertainmentCell(
        id = 11,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "eleven"
    ),    EntertainmentCell(
        id = 12,
        urlImage = "https://picsum.photos/200",
        title = "test 1",
        body = "twelve"
    ),
)