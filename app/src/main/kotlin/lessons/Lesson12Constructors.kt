/*
 * ============================================================================
 *  LESSON 12. CONSTRUCTORS
 * ============================================================================
 */
package lesson12

// the primary constructor goes right into the class header.
// val/var inside the parentheses turns a parameter into a property.
class Student(val name: String, var score: Int = 0) {

    // init runs whenever an object is created
    init {
        if (score < 0) score = 0
        // println("Student $name created")
    }

    // secondary constructor: accepts the score as text.
    // Rarely needed in practice - default values usually cover it.
    constructor(name: String, score: String) : this(name, score.toIntOrNull() ?: 0)

    override fun toString() = "$name ($score)"
}

fun main() {
    println("=== Lesson 12. Constructors ===")

    val a = Student("Anna", 78)
    val b = Student("Boris")            // score becomes 0
    val c = Student("Vera", "92")       // secondary constructor
    val d = Student("Gleb", -10)        // init fixes it to 0

    println("$a $b $c $d")

    a.score = 85                         // ok, it is a var
    // a.name = "Peter"                  // ERROR, it is a val
}
