package profile

fun main() {
    print("Enter 1st name: ")
    val firstName = readln()
    print("Enter 2nd name: ")
    val secondName = readln()

    print("Enter 1st lastname: ")
    val firstLastName = readln()
    print("Enter 2nd lastname: ")
    val secondLastName = readln()


    print("Enter 1st age: ")
    val firstAge = readln().toInt()
    print("Enter 2nd age: ")
    val secondAge = readln().toInt()

    print("Enter 1st height: ")
    val firstHeight = readln().toInt()
    print("Enter 2nd height: ")
    val secondHeight = readln().toInt()

    print("Enter 1st weight: ")
    val firstWeight = readln().toInt()
    print("Enter 2nd weight: ")
    val secondWeight = readln().toInt()

    val first = profile.Person(name = firstName, lastName = firstLastName,weight = firstWeight, height = firstHeight)
    val second = profile.Person(name = secondName, lastName = secondLastName , weight = secondWeight, height = secondHeight)

    println(first.fullName)
    println(second.fullName)

    first.age = firstAge
    second.age = secondAge

    first.printInfo()
    second.printInfo()

    second.lastName = firstLastName

    println(first.fullName)
    println(second.fullName)

    first.age = 0
    second.age = 0

    first.sayHello()
    second.sayHello()
}
