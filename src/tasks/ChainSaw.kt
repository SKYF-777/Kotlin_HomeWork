package tasks

class ChainSaw(
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price:Price,
    voltage: Int,
    val chainSawTireLength: Int,
    val chainLinksCount: Int,
    val chainStep: Double
): PowerTool(brand, model,power,weight,cableLength,price,voltage) {
    override fun turnOn() {
        println("Цепная пила пилит")
    }
}