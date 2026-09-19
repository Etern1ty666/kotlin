/*
 * ============================================================================
 *  LESSON 19. CLASS Any: equals() and hashCode(), and data classes
 * ============================================================================
 */
package lesson19

// equals is not overridden: == falls back to comparing references
class PlainProduct(val title: String, val price: Int)

class Product(val title: String, val price: Int) {

    override fun toString() = "$title - $price"

    override fun equals(other: Any?): Boolean {
        if (other !is Product) return false
        return title == other.title && price == other.price
    }

    // RULE: if you override equals, you must override hashCode too.
    // Otherwise the object gets "lost" in Map and Set: they search by hash first.
    override fun hashCode() = title.hashCode() * 31 + price
}

// a data class does all of this for you: toString, equals, hashCode and copy
data class ProductData(val title: String, val price: Int)

fun main() {
    println("=== Lesson 19. The Any class: equals() and hashCode() ===")

    println(PlainProduct("Case", 800) == PlainProduct("Case", 800))  // false
    println(Product("Case", 800) == Product("Case", 800))            // true
    println(ProductData("Case", 800) == ProductData("Case", 800))    // true

    // what a broken hashCode costs you: a Set keeps the duplicate
    println(setOf(PlainProduct("Case", 800), PlainProduct("Case", 800)).size)  // 2
    println(setOf(Product("Case", 800), Product("Case", 800)).size)            // 1

    // copy - a copy with one field changed, the rest carried over
    val cheaper = ProductData("Case", 800).copy(price = 640)
    println(cheaper)

    // a data class also prints nicely for free
    println(ProductData("Case", 800))
}
