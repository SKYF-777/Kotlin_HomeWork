package tasks

import kotlin.random.Random
class Monster(
    val pawsCount: Int,
    val eyesCount: Int,
    val fangsCount: Int,
    val clawsCount: Int,
    val tentaclesCount: Int
) {

    constructor(num: Int): this(num, num, num, num, num)

    constructor(): this(
        pawsCount = Random.nextInt(1, 11),
        eyesCount = Random.nextInt(1, 11),
        fangsCount = Random.nextInt(1, 11),
        clawsCount = Random.nextInt(1, 11),
        tentaclesCount = Random.nextInt(1, 11)
    )
    fun printInfo(){
        println("Кол-во лап: $pawsCount")
        println("Кол-во глаз: $eyesCount")
        println("Кол-во клыков: $fangsCount")
        println("Кол-во когтей: $clawsCount")
        println("Кол-во щупалец: $tentaclesCount")
    }
}