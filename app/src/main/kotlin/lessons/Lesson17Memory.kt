/*
 * ============================================================================
 *  LESSON 17. MEMORY STRUCTURE
 *
 *  Stack - local variables and function calls. Small, cleaned up automatically.
 *          Overflowing it gives StackOverflowError (usually endless recursion).
 *  Heap  - the objects themselves. Large, shared. Cleaned by the garbage collector.
 *
 *  A variable holds NOT the object but a reference (address) to it.
 * ============================================================================
 */
package lesson17

class Point(var x: Int, var y: Int)

fun main() {
    println("=== Lesson 17. Memory, == and === ===")

    val a = Point(1, 2)
    val b = Point(1, 2)      // a different object with the same data
    val c = a                // the same reference, the same object

    println(a === b)         // false - two different objects on the heap
    println(a === c)         // true  - one and the same reference
    println(a == b)          // false - equals is not overridden (see lesson 19)

    // changing through c also changes what we see through a
    c.x = 100
    println(a.x)             // 100

    // === compares references, == compares content,
    // but only if the class was told how to do it.

    // String already overrides equals, so it behaves as expected
    val s1 = "hello"
    val s2 = buildString { append("hel"); append("lo") }
    println(s1 == s2)        // true
    println(s1 === s2)       // false - different objects on the heap
}
