package profile

fun main() {
    print("Enter 1st name: ")
    val firstName = readln()
    print("Enter 2nd name: ")
    val secondName = readln()

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

    val first = profile.Person(name = firstName, age = firstAge, weight = firstWeight, height = firstHeight)
    val second = profile.Person(name = secondName, age = secondAge, weight = secondWeight, height = secondHeight)

    first.printInfo()
    second.printInfo()

    first.sayHello()
    second.sayHello()
}
