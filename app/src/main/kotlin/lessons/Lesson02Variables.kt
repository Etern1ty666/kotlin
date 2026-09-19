/*
 * ============================================================================
 *  LESSON 2. VARIABLES
 * ============================================================================
 */
package lesson02

fun main() {
    println("=== Lesson 2. Variables ===")

    val name = "Kirill"    // val - read only, cannot be reassigned
    var score = 0          // var - can be changed

    score = 10             // ok
    // name = "Peter"      // COMPILE ERROR: val cannot be reassigned

    // The type can be written explicitly or left to the compiler
    val age: Int = 21
    val city = "Stavropol"            // inferred as String

    println("$name, $age, $city, score = $score")

    // --- basic types ---
    val whole: Int = 42
    val big: Long = 42L                // the L suffix is required
    val decimal: Double = 3.14         // default type for fractional numbers
    val small: Float = 3.14f           // the f suffix is required
    val flag: Boolean = true
    val symbol: Char = 'A'             // single quotes - one character
    val text: String = "text"          // double quotes - a string

    println("$whole $big $decimal $small $flag $symbol $text")

    // --- types are checked strictly, no implicit conversion ---
    val n: Int = 10
    // val b: Long = n                 // ERROR
    val b: Long = n.toLong()           // correct
    val s: String = 5.toString()
    println("$b $s")

    // the type of a variable is fixed once, even for var
    var x = 1
    // x = "text"                      // ERROR: x is Int forever
    x = 99
    println("x = $x")

    // --- string templates ---
    val years = 20
    println("Next year it will be ${years + 1}")
    println("Name length: ${name.length}")

    // handy string methods
    println(name.uppercase())          // KIRILL
    println("  text  ".trim())         // "text"
    println(name.contains("iri"))      // true
    println("10 20 30".split(" "))     // [10, 20, 30]
}
