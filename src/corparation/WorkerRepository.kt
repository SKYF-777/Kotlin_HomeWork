package corparation

import java.io.File

class WorkerRepository {

    private val fileEmployees = File("employees.txt")
    val workers = loadAllCardsEmployee()

    fun registerNewEmployee(worker:Worker){
        workers.add(worker)
    }

    fun changeSalary(id: Int,salary:Int) {
        for(worker in workers){
            if(worker.id == id){
                worker.setSalary(salary)
            }
        }
    }


    fun saveChanges(){
        val content = StringBuilder()
        for(worker in workers){
            content.append("${worker.name}%${worker.age}%${worker.id}%${worker.getSalary()}%${worker.position}\n")
        }
        fileEmployees.writeText(content.toString())
    }

    private fun loadAllCardsEmployee(): MutableList<Worker> {
        val employees: MutableList<Worker> = mutableListOf()

        if (!fileEmployees.exists()) fileEmployees.createNewFile()

        val content = fileEmployees.readText().trim()

        if(content.isEmpty()) return  employees

        val employeesAsString = content.split("\n")
        for (employeeAsString in employeesAsString) {
            val properties = employeeAsString.split("%")
            val name = properties[0]
            val age = properties[1].toInt()
            val id = properties[2].toInt()
            val salary = properties[3].toInt()
            val positionAsText = properties.last()
            val position = Position.valueOf(positionAsText.trim().uppercase())
            val worker = when (position) {
                Position.DIRECTOR -> Director(name, age, salary, id)
                Position.ACCOUNTANT -> Accountant(name, age, salary, id)
                Position.ASSISTANT -> Assistant(name, age, salary, id)
                Position.CONSULTANT -> Consultant(name, age, salary, id)
            }
            employees.add(worker)
        }
        return employees
    }

    fun fireAnEmployee(id: Int){
        for(worker in workers){
            if(worker.id == id){  workers.remove(worker)
            break
            }
        }
    }
}