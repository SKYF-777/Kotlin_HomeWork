package corparation

abstract class Worker(
    val name: String,
    val age:Int = 0,
    val id:Int,
    val position: Position
) {
    var salary:Int = 15000

    abstract fun work()

    open fun printInfoEmployees(){
        print(this)
    }

    override fun toString(): String {
        return "Name: $name, Age: $age Id: $id, Position: $position, Salary: $salary \n"
    }
}