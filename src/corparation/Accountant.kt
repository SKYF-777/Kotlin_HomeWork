package corparation

class Accountant(
    name: String,
    age: Int,
    salary: Int,
    id: Int
) : Worker(
    name = name,
    age = age,
    id = id,
    salary = salary,
    position = Position.ACCOUNTANT
),Cleaner,Supplier {

    private val productRepository = ProductRepository()
    private val workerRepository = WorkerRepository

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
                OperationCode.EXIT -> {
                    workerRepository.saveChanges()
                    productRepository.saveChanges()
                    break
                }
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
        workerRepository.changeSalary(id, salary)
    }

    private fun removeProductCard() {
        print("Enter name of card for removing: ")
        val name = readln()
        productRepository.removeProductCard(name)
    }

    private fun showAllItems() {
        val cards = productRepository.productCards
        for (card in cards){
            card.printInfo()
        }

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
        productRepository.registerNewItem(card)
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
        val salary = readln().toInt()
        val worker = when (position) {

            Position.DIRECTOR -> Director(name, age, salary,id)
            Position.ACCOUNTANT -> Accountant(name, age, salary, id)
            Position.ASSISTANT -> Assistant(name, age, salary, id)
            Position.CONSULTANT -> Consultant(name, age, salary, id)
        }
        workerRepository.registerNewEmployee(worker)
    }

    private fun fireAnEmployee(){
        print("Enter employee's id to fire: ")
        val id = readln().toInt()
        workerRepository.fireAnEmployee(id)
    }

    private fun showAllEmployees() {
        val cards = workerRepository.workers
        for (card in cards){
            card.printInfoEmployees()
        }
    }

}