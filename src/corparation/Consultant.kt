package corparation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0,
    id: Int = 0,
    val positionConsultant: String
):Worker(name = name, age = age, id = id, position = Position.CONSULTANT) {
    override fun work() {
        serveCustomers()
    }

    fun serveCustomers():Int {
        val count = Random.nextInt(0, 100)
        repeat(count){
            println("The customer ie served...")
        }
        return count
    }

    fun sayHello(){
        print("Hello! My name is $name. ")
        if (age>0){
            print("I'm $age years old.\n")
        }
    }
}