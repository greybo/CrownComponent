package au.com.crownresorts.crma.compose.model

data class ChipsToggleModel(val name: String, var select: Boolean = false) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChipsToggleModel

        if (name != other.name) return false
        if (select != other.select) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + select.hashCode()
        return result
    }
}

//
//val fakeChipsList get() =  listOf(
//    ChipsToggleModel("one"),
//    ChipsToggleModel("two"),
//    ChipsToggleModel("three"),
//    ChipsToggleModel("four"),
//    ChipsToggleModel("five"),
//    ChipsToggleModel("six"),
//    ChipsToggleModel("seven"),
//    ChipsToggleModel("eight"),
//    ChipsToggleModel("nine"),
//    ChipsToggleModel("ten"),
//    ChipsToggleModel("eleven"),
//    ChipsToggleModel("twelve"),
//    ChipsToggleModel("thirteen")
//)