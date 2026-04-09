package corparation

open class Worker(
    val name: String,
    val age:Int = 0,
    val id:Int = 0,
    val position: Position
) {
    open fun work(){
        println("I'm working now ...")
    }

    open fun printInfoEmployees(){
        print("Name: ${this.name}, Age: ${this.age} Id: ${this.id}, Position: ${this.position.title} \n")
    }
}