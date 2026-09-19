/*
 * ============================================================================
 *  LESSON 7. STRING CONVERSION AND READING INPUT
 * ============================================================================
 */
package lesson07

fun main() {
    println("=== Lesson 7. Strings and input ===")

    // --- string to number and back ---
    println("42".toInt())
    println("3.14".toDouble())
    println(42.toString())

    // --- what if the string is garbage? ---
    // println("abc".toInt())            // CRASHES: NumberFormatException
    println("abc".toIntOrNull())         // null - the program keeps running

    // Rule for the whole course: the OrNull variant is safer.

    // --- parsing a string with several numbers ---
    val parts = "10 20 30".split(" ")
    var total = 0
    for (part in parts) {
        total += part.toIntOrNull() ?: 0
    }
    println("Total: $total")             // 60

    // --- reading from the keyboard ---
    // readLine() returns String? - there may be no input at all.
    // Uncomment to try it. The gradle task for this lesson forwards the
    // terminal input, so you can just type the answers.

    /*
    print("What is your name? ")
    val name = readLine()

    print("Year of birth? ")
    val year = readLine()?.trim()?.toIntOrNull() ?: 0

    println("Hello, ${name?.uppercase()}! You are ${2026 - year}.")
    */

    // MEMORIZE THE PATTERN:
    //     readLine()?.trim()?.toIntOrNull() ?: defaultValue
    // The ?. and ?: operators are covered in detail in lesson 10.
}
