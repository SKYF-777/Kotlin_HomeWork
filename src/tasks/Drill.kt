package tasks

class Drill(
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price:Price,
    voltage: Int,
    val drillChuckDiameter: Int,
    val minRotationSpeed: Int,
    val maxRotationSpeed: Int
): PowerTool(brand, model,power,weight,cableLength,price,voltage) {
    override fun turnOn() {
        println("Дрель сверлит")
    }
}