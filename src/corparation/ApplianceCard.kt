package corparation

class ApplianceCard(
    name: String,
    brand: String,
    price: Int,
    val wattage: Int
) : ProductCard(name, brand, price, ProductType.APPLIANCE) {


    override fun toString(): String {
        return "Name: ${this.name} Brend: ${this.brand} Price: ${this.price} ProductType: ${this.productType.title} Power $wattage"
    }
}