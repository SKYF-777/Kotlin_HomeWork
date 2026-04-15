package corparation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
) : ProductCard(name, brand, price, ProductType.SHOE) {

    override fun printInfo() {
        println("Name: ${this.name} Brend: ${this.brand} Price: ${this.price} ProductType: ${this.productType.title} Size: $size")
    }
}