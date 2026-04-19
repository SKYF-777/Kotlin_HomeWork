package corparation

abstract class Worker(
    val name: String,
    val age:Int = 0,
    val id:Int = 0,
    val position: Position
) {
    abstract fun work()

    open fun printInfoEmployees(){
        print(this)
    }

    override fun toString(): String {
        return "Name: ${this.name}, Age: ${this.age} Id: ${this.id}, Position: ${this.position.title} \n"
    }
}