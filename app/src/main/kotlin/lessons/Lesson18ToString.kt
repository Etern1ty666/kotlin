/*
 * ============================================================================
 *  LESSON 18. CLASS Any: toString()
 *  Every class inherits from Any, even when that is written nowhere.
 *  Any gives every object three methods: toString, equals and hashCode.
 *  This lesson is about the first one.
 * ============================================================================
 */
package lesson18

// without overriding toString you get the class name and an address
class PlainProduct(val title: String, val price: Int)

// with an override it becomes readable
class Product(val title: String, val price: Int) {
    override fun toString() = "$title - $price"
}

fun main() {
    println("=== Lesson 18. The Any class: toString() ===")

    println(PlainProduct("Case", 800))       // PlainProduct@7a81197d - unreadable
    println(Product("Case", 800))            // Case - 800

    // println calls toString() for you. So does string interpolation:
    val p = Product("Keyboard", 2500)
    println("In the cart: $p")

    // An array does not override toString either - that is why lesson 6
    // told you to use joinToString().
    println(arrayOf(1, 2, 3))                // [Ljava.lang.Integer;@...
    println(arrayOf(1, 2, 3).joinToString())  // 1, 2, 3
}
