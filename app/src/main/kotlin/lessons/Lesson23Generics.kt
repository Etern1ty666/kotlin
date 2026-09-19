/*
 * ============================================================================
 *  LESSON 23. GENERICS
 *  A type as a parameter: write once, works with any type.
 * ============================================================================
 */
package lesson23

// without generics you would need BoxInt, BoxString, BoxStudent, ...
class Box<T>(val value: T) {
    fun show() = println(value)
}

// a generic function
fun <T> firstOrDefault(items: List<T>, default: T): T =
    if (items.isEmpty()) default else items[0]

// a constraint: T must be comparable
fun <T : Comparable<T>> larger(a: T, b: T): T = if (a > b) a else b

fun main() {
    println("=== Lesson 23. Generics ===")

    Box(5).show()                  // Box<Int>, the type was inferred
    Box("text").show()             // Box<String>
    Box<Double>(1.5).show()        // written explicitly

    println(firstOrDefault(listOf(1, 2, 3), 0))
    println(firstOrDefault(emptyList<String>(), "empty"))

    println(larger(5, 9))              // 9
    println(larger("anna", "boris"))   // boris - strings are comparable too

    // You have used this already: Array<String> and List<Int> are generics.
}
