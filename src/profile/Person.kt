package profile

class Person(
    private val name: String,
    private val height: Int,
    private val weight: Int
) {

    var age:Int = 18
        set(value) {
            if (value > field){
                field = value
            }else{
                println("A person doesn't get any younger...")
            }
        }
        get() {
            println("Tt is indecent to ask a person his age")
            return field
        }


    fun printInfo(){
        println("Name: $name Age:$age Height:$height Weight:$weight")
    }
    fun sayHello(){
        println("Hello! My name is $name!")
    }
}