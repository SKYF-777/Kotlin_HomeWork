package corparation

class Director(
    name: String,
    age: Int,
    id: Int
): Worker(name = name,age = age,id = id, position = Position.DIRECTOR), Supplier {
    override fun work(){
        println("I'm drinking coffee...")
    }

    override fun buyThings() {
        println("My position is Director. I'm buying things...")
    }

    fun takeCoffee(assistant: Assistant){
        val drinkName: String = assistant.bringCoffee()
        println("Thank tou, ${assistant.name}! The $drinkName is vary tasty :)")
    }
    fun takeWork(consultant: Consultant){
        val countClient: Int = consultant.serveCustomers()
        println("Consultant ${consultant.name} served $countClient clients")
    }
}