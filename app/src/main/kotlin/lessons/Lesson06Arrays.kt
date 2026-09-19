/*
 * ============================================================================
 *  LESSON 6. ARRAYS
 *  The size is fixed at creation time and never changes.
 * ============================================================================
 */
package lesson06

fun main() {
    println("=== Lesson 6. Arrays ===")

    // created by listing the values
    val numbers = arrayOf(5, 12, 8, 3)
    val names = arrayOf("Anna", "Boris", "Vera")

    // an array of a given size, filled with zeros
    val zeros = IntArray(5)

    // filled by a formula: it is the index
    val squares = IntArray(5) { it * it }     // [0, 1, 4, 9, 16]

    println(numbers[0])       // 5 - indexing starts at zero
    println(numbers.size)     // 4
    println(zeros.joinToString())
    println(squares.joinToString())

    // --- iterating over values ---
    for (n in numbers) print("$n ")
    println()

    // --- iterating over indices ---
    for (idx in names.indices) {
        println("$idx: ${names[idx]}")
    }

    // --- changing an element (the array is mutable even when declared val) ---
    numbers[0] = 99
    println(numbers.joinToString())

    // --- ready-made operations ---
    println(numbers.sum())
    println(numbers.average())
    println(numbers.maxOrNull())
    println(numbers.sortedArray().joinToString())
    println(numbers.contains(8))
    println(numbers.reversed())

    // TRAP: println(numbers) prints [I@1b6d3586 - an address, not the elements.
    // Reason: an array does not override toString (see lesson 18).
    println(numbers.joinToString(", "))       // this is the correct way
}
