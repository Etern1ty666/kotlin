/*
 * ============================================================================
 *  LESSON 3. MATH OPERATIONS
 * ============================================================================
 */
package lesson03

fun main() {
    println("=== Lesson 3. Math ===")

    val a = 10
    val b = 3

    println(a + b)        // 13
    println(a - b)        // 7
    println(a * b)        // 30
    println(a / b)        // 3  - MAIN TRAP: two Int values produce an Int
    println(a % b)        // 1  - remainder

    // how to get a fractional result
    println(7 / 2)            // 3
    println(7.0 / 2)          // 3.5
    println(7 / 2.0)          // 3.5
    println(7.toDouble() / 2) // 3.5

    // average grade: the sum is Int, so divide by 3.0 instead of 3
    val average = (4 + 5 + 4) / 3.0
    println("Average: $average")       // 4.333333333333333

    // precedence works as in math
    println(2 + 2 * 2)        // 6
    println((2 + 2) * 2)      // 8

    // compound assignment - only for var
    var c = 5
    c += 3    // 8
    c -= 1    // 7
    c++       // 8
    c--       // 7
    println("c = $c")

    // typical uses of the remainder
    val number = 1234
    println("Even: ${number % 2 == 0}")
    println("Last digit: ${number % 10}")
}
