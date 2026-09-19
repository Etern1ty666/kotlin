/*
 * ============================================================================
 *  LESSON 21. EXCEPTIONS AND ERRORS
 * ============================================================================
 */
package lesson21

// a custom exception type
class EmptyCartException(message: String) : Exception(message)

fun setAge(age: Int) {
    if (age < 0) throw IllegalArgumentException("Age is below zero")
    // the same check in short form:
    // require(age >= 0) { "Age is below zero" }
}

fun main() {
    println("=== Lesson 21. Exceptions ===")

    val input = "abc"

    try {
        val n = input.toInt()
        println(100 / n)
    } catch (e: NumberFormatException) {
        println("Not a number")
    } catch (e: ArithmeticException) {
        println("Cannot divide by zero")
    } finally {
        println("Runs no matter what")
    }
    // There can be several catch blocks: the first matching type wins.
    // A generic Exception must come last.

    // try is an expression as well
    val n = try { input.toInt() } catch (e: Exception) { 0 }
    println("n = $n")

    try {
        setAge(-5)
    } catch (e: IllegalArgumentException) {
        println("Caught: ${e.message}")
    }

    try {
        throw EmptyCartException("The cart is empty")
    } catch (e: EmptyCartException) {
        println("Caught our own: ${e.message}")
    }

    // RULE: if you can avoid an exception, avoid it.
    // toIntOrNull instead of toInt, getOrNull instead of square brackets.
    // Exceptions are for situations that are genuinely abnormal.
}
