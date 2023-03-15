package au.com.crownresorts.crma.compose.screens.collections.model

data class EntertainmentCell(
    val id: Int,
    val urlImage: String,
    val title: String,
    val body: String
)

val cellList = listOf(
    EntertainmentCell(
        id = 1,
        urlImage = "https://picsum.photos/200/200?image=0",
        title = "test test test 1",
        body = "one"
    ),
    EntertainmentCell(
        id = 2,
        urlImage = "https://picsum.photos/200/200?image=81",
        title = "test 2",
        body = "two two two two two "
    ),
    EntertainmentCell(
        id = 3,
        urlImage = "https://picsum.photos/200/200?image=52",
        title = "test test test test 3 test 3 test 3 test 3 test 3 test 3",
        body = "three three three three three three three three three three three"
    ),
    EntertainmentCell(
        id = 4,
        urlImage = "https://picsum.photos/200/200?image=33",
        title = "test 1",
        body = "four"
    ),
    EntertainmentCell(
        id = 5,
        urlImage = "https://picsum.photos/200/200?image=44",
        title = "test 1",
        body = "five"
    ),
    EntertainmentCell(
        id = 6,
        urlImage = "https://picsum.photos/200/200?image=15",
        title = "test 1",
        body = "six"
    ),
    EntertainmentCell(
        id = 7,
        urlImage = "https://picsum.photos/200/200?image=25",
        title = "test 1",
        body = "seven"
    ),
    EntertainmentCell(
        id = 8,
        urlImage = "https://picsum.photos/200/200?image=319",
        title = "test 1",
        body = "eight"
    ),
    EntertainmentCell(
        id = 9,
        urlImage = "https://picsum.photos/200/200?image=18",
        title = "test 1",
        body = "nine"
    ),
    EntertainmentCell(
        id = 10,
        urlImage = "https://picsum.photos/200/200?image=9",
        title = "test 1",
        body = "ten"
    ),
    EntertainmentCell(
        id = 11,
        urlImage = "https://picsum.photos/200/200?image=110",
        title = "test 1",
        body = "eleven"
    ),
    EntertainmentCell(
        id = 12,
        urlImage = "https://picsum.photos/200/200?image=31",
        title = "test 1",
        body = "twelve"
    ),

)