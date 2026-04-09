package corparation

class Assistant(
    name: String,
    age: Int = 0,
    id: Int = 0,
    val positionAssistant: String
):Worker(name = name, age = age, id = id, position = Position.ASSISTANT) {
    override fun work() {
        println("I'm go to the coffee for my director...")
    }

    fun bringCoffee(drinkName: String = "Cappuccino", count:Int = 1): String {
        repeat(count){
            println("Get up")
            println("Go to the coffee machine")
            println("Press the \"$drinkName\" button")
            println("Wait for the $drinkName to be prepared")
            println("Take coffee")
            println("Bring coffee to the director")
            println("Put coffee on the table")
            println("Return to the workplace")
        }
        return "Espresso"
    }
}