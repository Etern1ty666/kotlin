/*
 * ============================================================================
 *  LESSON 5. LOOPS: while, do-while, for
 * ============================================================================
 */
package lesson05

fun main() {
    println("=== Lesson 5. Loops ===")

    // --- while: the check happens BEFORE the body ---
    var i = 0
    while (i < 5) {
        print(i)
        i++            // forget this and the loop runs forever
    }
    println()

    // --- do-while: the body runs at least once ---
    var attempt = 0
    do {
        attempt++
        println("Attempt $attempt")
    } while (attempt < 3)

    // --- for over ranges ---
    for (n in 1..5) print(n)          // 12345 - both bounds included
    println()

    for (n in 1 until 5) print(n)     // 1234 - upper bound NOT included
    println()

    for (n in 10 downTo 1) print(n)   // counting down
    println()

    for (n in 0..10 step 2) print("$n ")  // every second value
    println()

    // --- for over the characters of a string ---
    for (c in "Kotlin") print("$c ")
    println()

    // --- repeat: run N times without a counter ---
    repeat(3) { println("once more") }

    // --- break: leave the loop entirely ---
    for (n in 1..100) {
        if (n * n > 50) break
        print("$n ")
    }
    println()

    // --- continue: skip one iteration ---
    for (n in 1..10) {
        if (n % 2 != 0) continue
        print("$n ")                   // 2 4 6 8 10
    }
    println()

    // --- label: break out of two nested loops at once ---
    outer@ for (x in 1..5) {
        for (y in 1..5) {
            if (x * y > 6) break@outer
            print("$x*$y ")
        }
    }
    println()
}
