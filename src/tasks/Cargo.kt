package tasks

class Cargo(
    val length: Int,
    val width: Int,
    val height: Int,
    val typePackaging: String,
    val netWeight: Double,//груз без упаковки
    val grossWeight: Double//груз с упаковкой
) {
    fun printInfo(){
        println("Длина: ${this.length}")
        println("Ширина: ${this.width}")
        println("Высота: ${this.height}")
        println("Тип упаковки: ${this.typePackaging}")
        println("Вес нетто: ${this.netWeight}")
        println("Вес брутто: ${grossWeight}")
    }
}