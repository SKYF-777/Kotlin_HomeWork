package corparation

//fun main() {
//    print("Enter name: ")
//    val name = readln()
//    print("Enter brand: ")
//    val brand = readln()
//    print("Enter size: ")
//    val size = readln().toFloat()
//    print("Enter price: ")
//    val price = readln().toInt()
//    val productCard = ProductCard(name, brand, size, price)
//    productCard.printInfo()
//}

//fun main() {
//    val director = Director("Andrey", 25)
//    val assistant = Assistant("Jone")
//    director.takeCoffee(assistant)
//}

fun main() {
    val director = Director("Andrey", 35, id = 9876, "Director")
    val consultant = Consultant("Max", age = 45, id = 9576, "Consultant")
    val assistant = Assistant("Helen", 20, id = 9856,"Assistant" )
    val accountant =Accountant("Chester", 45, id = 4792, "Accountant")
    val employees = listOf<Worker>(director,consultant, assistant,accountant)
    for(employee in employees) {
        employee.work()
    }
}