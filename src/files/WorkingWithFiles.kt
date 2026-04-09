package files

import java.io.File

fun main() {
    val file = File("todo_list.txt")
    val operationCodes = ToDoList.entries
    while (true) {
        print("Complete your to-do list: ")
        for ((index, code) in operationCodes.withIndex()) {
            print("$index - ${code.title}")
            if (index < operationCodes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val operationCodesIndex = readln().toInt()
        val operationCod =operationCodes[operationCodesIndex]
        when(operationCod){
            ToDoList.EXIT -> break
            ToDoList.ADD_NEW_ITEM -> {
                print("Enter a new item: ")
                val item = readln()
                file.appendText("$item\n")
            }
            ToDoList.ALL_ITEM_LIST -> {
                val content = file.readText().trim()
                val list = content.split("\n")
                for((index,item) in list.withIndex()){
                    println("$index - $item")
                }
            }
        }
    }
}
//
//    val content = file.readText()
//    println(content)


//    while (true){
//        print("Enter a new item or 0 to exit: ")
//        val item = readln()
//        if (item == "0"){
//            break
//        }
//        file.appendText("$item\n")
//    }

