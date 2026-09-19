/*
 * ============================================================================
 *  LESSON 28. FINAL TASK: a console to-do list
 *  Brings together classes, collections, when, null safety, loops and functions.
 *
 *  This one reads from the keyboard, so run it in a terminal:
 *      ./gradlew lesson28 --console=plain -q
 * ============================================================================
 */
package lesson28

data class Task(val title: String, var done: Boolean = false)

fun main() {
    println("=== Lesson 28. Final task: to-do list ===")

    val tasks = mutableListOf<Task>()

    do {
        println("\n1 - add, 2 - show, 3 - close, 4 - exit")
        print("> ")
        val command = readLine()?.trim()

        when (command) {
            "1" -> {
                print("Title: ")
                val title = readLine()?.trim()
                if (title.isNullOrEmpty()) {
                    println("Empty title")
                } else {
                    tasks.add(Task(title))
                    println("Added")
                }
            }

            "2" -> {
                if (tasks.isEmpty()) {
                    println("The list is empty")
                } else {
                    for ((i, task) in tasks.withIndex()) {
                        val mark = if (task.done) "[x]" else "[ ]"
                        println("$i $mark ${task.title}")
                    }
                    val closed = tasks.count { it.done }
                    println("Closed $closed out of ${tasks.size}")
                }
            }

            "3" -> {
                print("Number: ")
                val index = readLine()?.trim()?.toIntOrNull()
                val task = index?.let { tasks.getOrNull(it) }
                if (task == null) {
                    println("No such number")
                } else {
                    task.done = true
                    println("Closed: ${task.title}")
                }
            }

            "4" -> println("Bye!")

            null -> println("No input - stopping")

            else -> println("Unknown command")
        }
    } while (command != "4" && command != null)
}
