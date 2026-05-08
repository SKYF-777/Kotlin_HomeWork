package corparation

import java.io.File

class WorkerRepository {

    private val fileEmployees = File("employees.txt")

    fun registerNewEmployee(worker:Worker){
        saveWorkerToFile(worker)
    }

    fun changeSalary(id: Int,salary:Int) {
        val cards = loadAllCardsEmployee()
        fileEmployees.writeText("")
        for(card in cards){
            if(card.id == id){
                card.setSalary(salary)
            }
            saveWorkerToFile(card)
        }
    }

    private fun saveWorkerToFile(worker: Worker) {
        fileEmployees.appendText("${worker.name}%${worker.age}%${worker.id}%${worker.getSalary()}%${worker.position}\n")
    }

    fun loadAllCardsEmployee(): MutableList<Worker> {
        val cards: MutableList<Worker> = mutableListOf()

        if (!fileEmployees.exists()) fileEmployees.createNewFile()

        val employees = fileEmployees.readText().trim()

        if(employees.isEmpty()){
            return cards
        }
        val employeesAsString = employees.split("\n")
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
            cards.add(worker)
        }
        return cards
    }

    fun fireAnEmployee(id: Int){
        val cards = loadAllCardsEmployee()
        cards.removeIf { it.id == id }
        fileEmployees.writeText("")
        for(card in cards){
            saveWorkerToFile(card)
        }
    }
}