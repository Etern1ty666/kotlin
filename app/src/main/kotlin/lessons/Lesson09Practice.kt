/*
 * ============================================================================
 *  LESSON 9. PRACTICE
 *  Task: an array of scores, print a grade for each one, compute the average.
 * ============================================================================
 */
package lesson09

// the same helper as in lesson 8 - each lesson file stands on its own
fun gradeByScore(score: Int) = when {
    score >= 90 -> "excellent"
    score >= 70 -> "good"
    score >= 50 -> "satisfactory"
    else -> "unsatisfactory"
}

fun main() {
    println("=== Lesson 9. Practice ===")

    val scores = arrayOf(45, 62, 78, 95)
    for (score in scores) {
        println("$score -> ${gradeByScore(score)}")
    }
    println("Average: ${scores.average()}")
}
