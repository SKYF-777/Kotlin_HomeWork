package corparation

import java.io.File

class Accountant(
    name: String,
    age: Int,
    id: Int
) : Worker(name, age, id, Position.ACCOUNTANT),Cleaner,Supplier {

    private val fileProductCards = File("product_cards.txt")
    private val fileEmployees = File("employees.txt")

    override fun clean() {
        println("My position is Accountant. I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("My position is Accountant. I'm buying things...")
    }

    override fun work() {
        print("Operation code:")
        val operationCodes = OperationCode.entries
        while (true) {
            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}")
                if (index < operationCodes.size - 1) {
                    print("\n")
                } else {
                    print("\nEnter the operation code: ")
                }
            }
            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE ->registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private  fun changeSalary() {
        print("Enter employee's id to change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val salary = readln().toInt()
        val cards = loadAllCardsEmployee()
        fileEmployees.writeText("")
        for(card in cards){
            if(card.id == id){
               card.salary = salary
            }
            saveWorkerToFile(card)
        }
    }

    private fun removeProductCard() {
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Enter name of card for removing: ")
        val name = readln()
        for(card in cards){
            if(card.name == name){
                cards.remove(card)
                break
            }
        }
        fileProductCards.writeText("")
        for(card in cards){
            saveProductCardToFile(card)
        }
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf<ProductCard>()

        if (!fileProductCards.exists()) fileProductCards.createNewFile()

        val content = fileProductCards.readText().trim()

        if(content.isEmpty()){
            return cards
        }
        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD ->{
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }
                ProductType.APPLIANCE ->{
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }
                ProductType.SHOE ->{
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    private fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards){
            card.printInfo()
        }

    }

    private fun saveProductCardToFile(productCard: ProductCard) {
        fileProductCards.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                val caloric = productCard.caloric
                fileProductCards.appendText("$caloric%")
            }

            is ShoeCard -> {
                val size = productCard.size
                fileProductCards.appendText("$size%")
            }

            is ApplianceCard -> {
                val wattage = productCard.wattage
                fileProductCards.appendText("$wattage%")
            }
        }
        fileProductCards.appendText("${productCard.productType}\n")
    }

    private fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType: ProductType = productTypes[productTypeIndex]
        print("Enter the product name: ")
        val productName = readln()
        print("Enter yhe product brand: ")
        val productBrand = readln()
        print("Enter the product price: ")
        val productPrice = readln().toInt()
        val card = when (productType) {

            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                FoodCard(productName, productBrand,productPrice, caloric)

            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(productName, productBrand,productPrice, wattage)
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                ShoeCard(productName, productBrand,productPrice, size)

            }
        }
        saveProductCardToFile(card)
    }

    private fun registerNewEmployee() {
        val positions = Position.entries
        print("Choose position -  ")
        for ((index, position) in positions.withIndex()) {
            print("$index - ${position.title}")
            if (index < positions.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val positionIndex = readln().toInt()
        val position: Position = positions[positionIndex]
        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        print("Enter salary: ")
        val Salary = readln().toInt()
        val worker = when (position) {

            Position.DIRECTOR -> Director(name, age, id)
            Position.ACCOUNTANT -> Accountant(name, age, id)
            Position.ASSISTANT -> Assistant(name, age, id)
            Position.CONSULTANT -> Consultant(name, age, id)
        }
        worker.salary = Salary
        saveWorkerToFile(worker)
    }

    private fun fireAnEmployee(){
        val cards = loadAllCardsEmployee()
        print("Enter employee's id to fire: ")
        val id = readln().toInt()
        cards.removeIf { it.id == id }
        fileEmployees.writeText("")
        for(card in cards){
            saveWorkerToFile(card)
        }
    }

    fun loadAllCardsEmployee(): MutableList<Worker> {
        val cards: MutableList<Worker> = mutableListOf<Worker>()

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
            val position = Position.valueOf(positionAsText)
            val worker = when (position) {
                Position.DIRECTOR -> Director(name, age, id)
                Position.ACCOUNTANT -> Accountant(name, age, id)
                Position.ASSISTANT -> Assistant(name, age, id)
                Position.CONSULTANT -> Consultant(name, age, id)
            }
            worker.salary = salary
            cards.add(worker)
        }
        return cards
    }

    private fun showAllEmployees() {
        val cards = loadAllCardsEmployee()
        for (card in cards){
            card.printInfoEmployees()
        }
    }

    private fun saveWorkerToFile(worker: Worker) {
        fileEmployees.appendText("${worker.name}%${worker.age}%${worker.id}%${worker.salary}%${worker.position}\n")
    }

}