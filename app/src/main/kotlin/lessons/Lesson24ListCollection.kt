/*
 * ============================================================================
 *  LESSON 24. COLLECTIONS. LIST
 *  Difference from an array: a list can grow and shrink.
 * ============================================================================
 */
package lesson24

// the same class as in lesson 12 - each lesson file stands on its own
class Student(val name: String, var score: Int = 0) {
    override fun toString() = "$name ($score)"
}

fun main() {
    println("=== Lesson 24. List ===")

    // --- List: read only ---
    val names = listOf("Anna", "Boris", "Vera")

    println(names[0])
    println(names.size)
    println(names.first())
    println(names.last())
    println(names.getOrNull(10))       // null instead of a crash
    // names.add("Gleb")               // no such method

    // but you can get a new list
    println(names + "Gleb")

    // --- MutableList: modifiable ---
    val list = mutableListOf(1, 2)
    list.add(3)                         // [1, 2, 3]
    list.remove(1)                      // [2, 3]
    list.removeAt(0)                    // [3]
    list[0] = 99                        // [99]
    println(list)
    list.clear()                        // []

    // Note the val in front of mutableListOf. The reference cannot change,
    // the content can. These are two different things.

    // --- operations instead of loops ---
    val numbers = listOf(5, 12, 8, 3, 20)

    println(numbers.filter { it > 7 })  // [12, 8, 20] - keep the matching ones
    println(numbers.map { it * 2 })     // [10, 24, 16, 6, 40] - transform
    println(numbers.sorted())           // [3, 5, 8, 12, 20]
    println(numbers.sum())
    println(numbers.average())
    println(numbers.maxOrNull())
    println(numbers.count { it > 7 })   // 3
    println(numbers.any { it > 15 })    // true - at least one
    println(numbers.all { it > 0 })     // true - every one
    println(numbers.joinToString(" | "))

    // it is the current element. The original list is not modified,
    // a new one is returned.

    // --- chains ---
    val students = listOf(
        Student("Anna", 78), Student("Boris", 45), Student("Vera", 92)
    )

    val passed = students
        .filter { it.score >= 60 }
        .sortedBy { it.score }
        .map { it.name }

    println(passed)                     // [Anna, Vera]
    println(students.sumOf { it.score })
    println(students.maxByOrNull { it.score }?.name)
}
