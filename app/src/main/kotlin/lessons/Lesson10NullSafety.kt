/*
 * ============================================================================
 *  LESSON 10. NULL AND NULL SAFETY
 *  The key feature of the language: the compiler will not let you touch
 *  something that may not be there.
 * ============================================================================
 */
package lesson10

class User(val name: String, val address: Address?)
class Address(val city: String)

fun safeCast(value: Any) {
    val number = value as? Int ?: 0
    println("Number: $number")
}

fun main() {
    println("=== Lesson 10. Null safety ===")

    val a: String = "text"
    // a = null                     // ERROR: String cannot hold null

    var b: String? = "text"         // the question mark means "may be null"
    b = null                        // ok

    println(a.length)               // ok, this one can never be null
    // println(b.length)            // ERROR: what if b is null right now?

    // --- four tools ---

    // 1) ?.  safe call: null on the left means the whole expression is null
    println(b?.length)              // null

    b = "hello"
    println(b?.length)              // 5

    // 2) ?:  elvis: if the left side is null, take the right side
    val length = b?.length ?: 0
    println(length)

    // 3) a plain check: inside the branch b is already treated as non-null
    if (b != null) {
        println(b.length)           // no manual cast needed
    }

    // 4) !!  "trust me, it is not null". If you lied - NullPointerException.
    //    This switches off the protection of the language, use it last.
    println(b!!.length)

    // --- chains: they stop at the first null ---
    val user: User? = User("Anna", Address("Stavropol"))
    val city = user?.address?.city ?: "not specified"
    println(city)

    val missing: User? = null
    println(missing?.address?.city ?: "not specified")

    // --- let: run a block only if the value exists ---
    b?.let {
        println("Length: ${it.length}")  // it is the string itself, non-null
    }

    // --- as? safe cast: wrong type gives null instead of a crash ---
    safeCast("text")
    safeCast(42)
}
