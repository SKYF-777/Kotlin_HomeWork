package Ai_tasks

class BankAccount {
    var balance: Int = 0
        private set

    var ownerName: String = ""
        set(value) {
            if (value.length >= 2) field = value
            else println("Имя слишком короткое!")
        }

    private var pin: String = ""
        set(value) {
            if (value.length == 4) field = value
            else println("Пин должен быть 4 символа!")
        }

    fun deposit(amount: Int) {
        if (amount > 0) balance += amount
        else println("Сумма должна быть положительной!")
    }

    fun withdraw(amount: Int) {
        if (amount > balance) println("Недостаточно средств!")
        else balance -= amount
    }

    fun checkPin(input: String): Boolean {
        return input == pin
    }
}