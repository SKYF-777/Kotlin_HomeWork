package corparation

abstract class ProductCard(
    val name: String,
    val brand: String,
    val price: Int,
    val productType: ProductType
) {

    fun printInfo (){
        println(this)
    }
}