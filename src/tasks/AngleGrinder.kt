package tasks

class AngleGrinder(
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price:Price,
    voltage: Int,
    val discDiameter: Int,
    val isSmoothStart: Boolean,
    val isDustProtection: Boolean
):PowerTool(brand, model,power,weight,cableLength,price,voltage) {
    override fun turnOn() {
        println("УШМ режет")
    }
}