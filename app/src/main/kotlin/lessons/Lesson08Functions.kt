/*
 * ============================================================================
 *  LESSON 8. FUNCTIONS
 * ============================================================================
 */
package lesson08

// full form: name, typed parameters, return type
fun sum(a: Int, b: Int): Int {
    return a + b
}

// short form: a single-expression body, no braces and no return
fun sumShort(a: Int, b: Int) = a + b

// returns nothing - the type is Unit, which can be omitted
fun greet(name: String) {
    println("Hello, $name")
}

// default parameter values
fun greeting(name: String, salutation: String = "Hello") {
    println("$salutation, $name!")
}

// one function - one job
fun isEven(n: Int) = n % 2 == 0

fun gradeByScore(score: Int) = when {
    score >= 90 -> "excellent"
    score >= 70 -> "good"
    score >= 50 -> "satisfactory"
    else -> "unsatisfactory"
}

// recursion: a function calling itself.
// An exit condition is mandatory, otherwise StackOverflowError.
fun factorial(n: Int): Long = if (n <= 1) 1L else n * factorial(n - 1)

fun main() {
    println("=== Lesson 8. Functions ===")

    println(sum(2, 3))
    println(sumShort(2, 3))
    greet("Anna")

    greeting("Anna")                                  // Hello, Anna!
    greeting("Anna", "Hi there")                      // Hi there, Anna!
    greeting(salutation = "Greetings", name = "Anna") // order does not matter

    println(isEven(10))
    println(gradeByScore(78))
    println(factorial(5))                             // 120
}
