/*
 * ============================================================================
 *  LESSON 11. CLASSES AND OBJECTS
 *  A class is a blueprint. An object is one instance built from it.
 * ============================================================================
 */
package lesson11

// version without a constructor: fields declared in the body
class SimpleStudent {
    var name: String = ""
    var score: Int = 0

    // a method is a function inside a class
    fun addPoints(points: Int) {
        score += points
    }

    // computed property: not stored, calculated on every access
    val passed: Boolean
        get() = score >= 60
}

fun main() {
    println("=== Lesson 11. Classes and objects ===")

    val s = SimpleStudent()         // there is no new keyword in Kotlin
    s.name = "Anna"
    s.score = 55

    println("${s.name}, passed: ${s.passed}")   // false
    s.addPoints(10)
    println("${s.name}, score ${s.score}, passed: ${s.passed}")  // true
}
