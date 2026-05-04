package corparation

abstract class Worker(
    val name: String,
    val age:Int = 0,
    val id:Int,
    private var salary:Int = 15000,
    val position: Position
) {
    fun getSalary() = this.salary

    fun setSalary(salary: Int) {
        if (salary < this.salary) {
            println("the new salary is too small...")
        } else {
            this.salary = salary
        }
    }

    abstract fun work()

    open fun printInfoEmployees(){
        print(this)
    }

    override fun toString(): String {
        return "Name: $name, Age: $age Id: $id, Position: $position, Salary: $salary \n"
    }
}