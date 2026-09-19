/*
 * ============================================================================
 *  LESSON 27. COLLECTIONS. SET
 *  A set with no duplicates. Order is not guaranteed, there are no indices.
 * ============================================================================
 */
package lesson27

fun main() {
    println("=== Lesson 27. Set ===")

    val tags = setOf("kotlin", "android", "kotlin")
    println(tags.size)                   // 2, the duplicate is gone
    println(tags.contains("kotlin"))     // true

    // removing duplicates from a list
    println(listOf(1, 2, 2, 3, 3, 3).toSet())

    val s = mutableSetOf<String>()
    println(s.add("new"))                // true - was not there
    println(s.add("new"))                // false - already present

    // operations as in mathematics
    val a = setOf(1, 2, 3)
    val b = setOf(3, 4)
    println(a union b)                   // [1, 2, 3, 4]
    println(a intersect b)               // [3]
    println(a subtract b)                // [1, 2]

    // SUMMARY OF THE THREE COLLECTION LESSONS:
    //   List - when order matters and you need indices
    //   Map  - when you need a fast lookup by key
    //   Set  - when uniqueness matters
}
