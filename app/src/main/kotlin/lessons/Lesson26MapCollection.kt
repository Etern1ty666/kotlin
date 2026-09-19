/*
 * ============================================================================
 *  LESSON 26. COLLECTIONS. MAP
 *  A dictionary: key -> value. Keys are unique.
 * ============================================================================
 */
package lesson26

fun main() {
    println("=== Lesson 26. Map ===")

    val ages = mapOf("Anna" to 20, "Boris" to 22)

    println(ages["Anna"])                       // 20
    println(ages["Nobody"])                     // null - no such key
    println(ages.getOrDefault("Nobody", 0))     // 0
    println(ages.keys)
    println(ages.values)
    println(ages.size)

    // a lookup by key always returns a nullable type
    val age = ages["Anna"] ?: 0
    println(age)

    // destructuring the pair into two variables
    for ((name, years) in ages) {
        println("$name: $years")
    }

    // a mutable map
    val m = mutableMapOf<String, Int>()
    m["Vera"] = 19
    m["Gleb"] = 21
    m["Vera"] = 20              // writing to an existing key overwrites it
    m.remove("Gleb")
    println(m)

    // the same operations work here too
    println(ages.filter { it.value >= 21 })
}
