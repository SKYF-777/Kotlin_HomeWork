package Ai_tasks

fun main() {
    val account = BankAccount()

    println("Введите имя владельца:")
    account.ownerName = readLine() ?: ""

    println("Введите пин-код (4 символа):")
    val pinInput = readLine() ?: ""

    println("Введите сумму для пополнения:")
    val depositAmount = readLine()?.toIntOrNull() ?: 0
    account.deposit(depositAmount)

    println("Введите сумму для снятия:")
    val withdrawAmount = readLine()?.toIntOrNull() ?: 0
    account.withdraw(withdrawAmount)

    println("Ваш баланс: ${account.balance}")

    println("Введите пин-код для проверки:")
    val checkInput = readLine() ?: ""
    println("Пин верный: ${account.checkPin(checkInput)}")
}