package corparation

import java.io.File

class Accountant(
    name: String,
    age: Int,
    id: Int,
    val positionAccountant: String
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
            }
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
        val employeeTypes = Position.entries
        print("Choose position -  ")
        for ((index, type) in employeeTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < employeeTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val employeeTypeIndex = readln().toInt()
        val employeeType: Position = employeeTypes[employeeTypeIndex]
        print("Enter id: ")
        val employeeId = readln().toInt()
        print("Enter name: ")
        val employeeName = readln()
        print("Enter age: ")
        val employeeAge = readln().toInt()
        val cardEmploy = when (employeeType) {

            Position.DIRECTOR -> {
                val positionDirector = "Director"
                Director(employeeName, employeeAge, employeeId, positionDirector,)
            }
            Position.ACCOUNTANT -> {
                val positionAccountant = "Accountant"
                Accountant(employeeName, employeeAge, employeeId, positionAccountant,)
            }
            Position.ASSISTANT -> {
                val positionAssistant = "Assistant "
                Assistant(employeeName, employeeAge, employeeId, positionAssistant,)
            }
            Position.CONSULTANT -> {
                val positionConsultant = "Consultant"
                Consultant(employeeName, employeeAge, employeeId, positionConsultant,)
            }
        }
        saveWorkerToFile(cardEmploy)
    }

    private fun fireAnEmployee(){
        val cards = loadAllCardsEmployee()
        print("Enter id employee: ")
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
        val cardsAsString = employees.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val age = properties[1].toInt()
            val id = properties[2].toInt()
            val type = properties.last()
            val employeeType = Position.valueOf(type)
            val employeeCard = when (employeeType) {
                Position.DIRECTOR -> {
                    val positionDirector = "Director"
                    Director(name, age, id, positionDirector,)
                }
                Position.ACCOUNTANT -> {
                    val positionAccountant = "Accountant"
                    Accountant(name, age, id, positionAccountant,)
                }
                Position.ASSISTANT -> {
                    val positionAssistant = "Assistant "
                    Assistant(name, age, id, positionAssistant,)
                }
                Position.CONSULTANT -> {
                    val positionConsultant = "Consultant"
                    Consultant(name, age, id, positionConsultant,)
                }
            }
            cards.add(employeeCard)
        }
        return cards
    }

    private fun showAllEmployees() {
        val cards = loadAllCardsEmployee()
        for (card in cards){
            card.printInfoEmployees()
        }
    }

    private fun saveWorkerToFile(employeeCard: Worker) {
        fileEmployees.appendText("${employeeCard.name}%${employeeCard.age}%${employeeCard.id}%")
        when (employeeCard) {
            is Director -> {
                fileEmployees.appendText("${employeeCard.positionDirector}%")
            }

            is Accountant -> {
                fileEmployees.appendText("$positionAccountant%")
            }

            is Assistant -> {
                fileEmployees.appendText("${employeeCard.positionAssistant}%")
            }

            is Consultant ->{
                fileEmployees.appendText("${employeeCard.positionConsultant}%")

            }
        }
        fileEmployees.appendText("${employeeCard.position}\n")
    }

}