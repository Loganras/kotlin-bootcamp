package spices

class SimpleSpice(){
    val name = "curry"
    val spiciness = "mild"
    val heat: Int
        get() {return 5 }
}

//abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
//    abstract fun prepareSpice()
//}

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {

    abstract fun prepareSpice()

    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 2
                "spicy" -> 3
                else -> 0
            }
        }
}

interface Grinder {
    fun grind()
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0XFFFF00)
}

interface SpiceColor {
    val color: Color
}

object YellowSpice: SpiceColor {
    override val color = Color.YELLOW
}

class Curry(name: String, spiciness: String,
            color: SpiceColor = YellowSpice) : Spice(name, spiciness, color), Grinder {

    override fun grind() {
        println("grind spice")
    }
    override fun prepareSpice() {
        grind()
    }
}

data class SpiceContainer (val spice: Spice) {
    val label = spice.name
}

fun main() {
    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
            SpiceContainer(Curry("Red Curry", "medium")),
            SpiceContainer(Curry("Green Curry", "spicy")))

    for(element in spiceCabinet) println(element.label)
}