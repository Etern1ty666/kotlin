/*
 * ============================================================================
 *  LESSON 4. CONDITIONS: if-else, when
 * ============================================================================
 */
package lesson04

fun main() {
    println("=== Lesson 4. Conditions ===")

    val score = 78

    // plain if-else
    if (score >= 60) {
        println("passed")
    } else if (score >= 40) {
        println("retake")
    } else {
        println("failed")
    }

    // comparison operators:  ==  !=  >  <  >=  <=
    // logical operators:     &&  ||  !
    println(score > 0 && score <= 100)
    println(score < 0 || score > 100)
    println(!(score > 0))

    // --- if as an expression (Kotlin has no ternary operator) ---
    val a = 5
    val b = 9
    val max = if (a > b) a else b
    println("Max: $max")

    // the value of a block is its last line
    val status = if (score >= 60) {
        "passed"
    } else {
        "failed"
    }
    println(status)
    // when if is used as a value, the else branch is MANDATORY

    // --- when by value ---
    val day = 6
    val dayName = when (day) {
        1, 2, 3, 4, 5 -> "weekday"     // several values separated by commas
        6 -> "saturday"
        7 -> "sunday"
        else -> "no such day"
    }
    println(dayName)                    // no break statements needed

    // --- when by range ---
    val grade = when (score) {
        in 90..100 -> "excellent"
        in 70..89 -> "good"
        in 50..69 -> "satisfactory"
        else -> "unsatisfactory"
    }
    println(grade)

    // --- when without an argument: replaces a long if-else ladder ---
    val temperature = 8
    when {
        temperature < 0 -> println("freezing")
        temperature < 15 -> println("chilly")
        else -> println("warm")
    }

    // --- when by type (smart cast) ---
    printLength("some text")
    printLength(41)
}

fun printLength(value: Any) {
    val result = when (value) {
        is String -> value.length      // inside the branch value is already String
        is Int -> value + 1            // inside the branch value is already Int
        else -> 0
    }
    println("Result: $result")
}
