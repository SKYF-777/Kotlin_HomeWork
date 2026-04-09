package tasks

//fun main() {
//    val daysOfWeek = DaysOfWeek.entries
//    for(day in daysOfWeek){
//        println(day.title)
//    }
//}

fun task(listUser: List<String>): List<String> {
    val users = listUser.toMutableList()
    val action = readLine()!!

    when (action) {
        "SHOW"      -> showUsers(users)
        "ADD"       -> addUser(users)
        "REMOVE"    -> removeUser(users)
        "REMOVE_AT" -> removeUserAt(users)
        else        -> println("Некорректное значение")
    }

    return users.toList()
}

private fun showUsers(users: List<String>) {
    for (i in users.indices) {
        println(users[i])
    }
}

private fun addUser(users: MutableList<String>) {
    val newUser = readLine()!!
    users.add(newUser)
    showUsers(users)
}

private fun removeUser(users: MutableList<String>) {
    val toRemove = readLine()!!
    users.remove(toRemove)
    showUsers(users)
}

private fun removeUserAt(users: MutableList<String>) {
    val index = readLine()!!.toInt()
    if (index in users.indices) {
        users.removeAt(index)
    }
    showUsers(users)
}



