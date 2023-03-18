package au.com.crownresorts.crma.compose.screens.collections.model

data class HitModel(
    val hitId: Int, val urlImage: String, val title: String, val body: String, val category: String
)

val fakeCellList = listOf(
    HitModel(
        hitId = 1, urlImage = "https://picsum.photos/200/200?image=0", title = "Restaurant Restaurant ", body = "one", category = "Restaurant"
    ),
    HitModel(
        hitId = 2, urlImage = "https://picsum.photos/200/200?image=81", title = "Restaurant ", body = "two two two two two ", category = "Restaurant"
    ),
    HitModel(
        hitId = 3,
        urlImage = "https://picsum.photos/200/200?image=52",
        title = "Restaurant Restaurant Restaurant Restaurant Restaurant",
        body = "three three three three three three three three three three three",
        category = "Restaurant"
    ),
    HitModel(
        hitId = 4, urlImage = "https://picsum.photos/200/200?image=33", title = "Restaurant", body = "four", category = "Restaurant"
    ),
    HitModel(
        hitId = 5, urlImage = "https://picsum.photos/200/200?image=44", title = "Restaurant", body = "five", category = "Restaurant"
    ),
    HitModel(
        hitId = 6, urlImage = "https://picsum.photos/200/200?image=15", title = "Restaurant", body = "six", category = "Restaurant"
    ),
    HitModel(
        hitId = 7, urlImage = "https://picsum.photos/200/200?image=25", title = "Bars", body = "seven", category = "Bars"
    ),
    HitModel(
        hitId = 8, urlImage = "https://picsum.photos/200/200?image=319", title = "Bars", body = "eight", category = "Bars"
    ),
    HitModel(
        hitId = 9, urlImage = "https://picsum.photos/200/200?image=18", title = "Bars", body = "nine", category = "Bars"
    ),
    HitModel(
        hitId = 10, urlImage = "https://picsum.photos/200/200?image=9", title = "Bars", body = "ten", category = "Bars"
    ),
    HitModel(
        hitId = 11, urlImage = "https://picsum.photos/200/200?image=110", title = "Bars", body = "eleven", category = "Bars"
    ),
    HitModel(
        hitId = 12, urlImage = "https://picsum.photos/200/200?image=31", title = "Bars", body = "twelve", category = "Bars"
    ),
    HitModel(
        hitId = 13, urlImage = "https://picsum.photos/200/200?image=34", title = "SportBar", body = "thirteen", category = "SportBar"
    ),
    HitModel(
        hitId = 14, urlImage = "https://picsum.photos/200/200?image=35", title = "Large", body = "fourteen", category = "Large"
    ),
    HitModel(
        hitId = 15, urlImage = "https://picsum.photos/200/200?image=36", title = "Large", body = "fourteen", category = "Large"
    ),
    HitModel(
        hitId = 16, urlImage = "https://picsum.photos/200/200?image=37", title = "Large", body = "fourteen", category = "Large"
    ),
    HitModel(
        hitId = 17, urlImage = "https://picsum.photos/200/200?image=38", title = "Large", body = "fourteen", category = "Large"
    ),
    HitModel(
        hitId = 18, urlImage = "https://picsum.photos/200/200?image=39", title = "Large", body = "fourteen", category = "Large"
    ),
    HitModel(
        hitId = 19, urlImage = "https://picsum.photos/200/200?image=40", title = "Large", body = "fourteen", category = "Large"
    ),
    HitModel(
        hitId = 20, urlImage = "https://picsum.photos/200/200?image=41", title = "Move", body = "fourteen", category = "Move"
    ),HitModel(
        hitId = 21, urlImage = "https://picsum.photos/200/200?image=41", title = "Move", body = "fourteen", category = "Move"
    ),HitModel(
        hitId = 22, urlImage = "https://picsum.photos/200/200?image=41", title = "Move", body = "fourteen", category = "Move"
    ),HitModel(
        hitId = 23, urlImage = "https://picsum.photos/200/200?image=41", title = "Move", body = "fourteen", category = "Move"
    ),HitModel(
        hitId = 24, urlImage = "https://picsum.photos/200/200?image=41", title = "Move", body = "fourteen", category = "Move"
    ),HitModel(
        hitId = 25, urlImage = "https://picsum.photos/200/200?image=41", title = "Move", body = "fourteen", category = "Move"
    ),
)