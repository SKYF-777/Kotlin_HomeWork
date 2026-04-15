package corparation

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int
):ProductCard(name,brand,price, ProductType.FOOD) {

    override fun printInfo() {
        println("Name: ${this.name} Brend: ${this.brand} Price: ${this.price} ProductType: ${this.productType.title} Caloric: $caloric")
    }
}