package corparation

open class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val productType: ProductType
) {

    open fun printInfo (){
        print("Name: ${this.name} Brend: ${this.brand} Price: ${this.price} ProductType: ${this.productType.title}")
    }
}