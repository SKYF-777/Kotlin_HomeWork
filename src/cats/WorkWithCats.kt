package cats

fun main() {
    val cat = Cat("Sam")
    println(cat.legsCount)
    println(cat.name)
    val lion = Lion(25)
    println(lion.countInPride)
    println(lion.legsCount)
    cat.playWithMouse()
}