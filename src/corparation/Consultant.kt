package corparation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int,
    id: Int
):Worker(name = name, age = age, id = id, position = Position.CONSULTANT), Cleaner {
    override fun work() {
        serveCustomers()
    }

    override fun clean() {
        println("My position is Consultant. I'm cleaning workplace...")
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