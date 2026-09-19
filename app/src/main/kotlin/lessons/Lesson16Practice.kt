/*
 * ============================================================================
 *  LESSON 16. PRACTICE: employee hierarchy
 *  The loop is the same for everyone, but the salary is computed differently.
 * ============================================================================
 */
package lesson16

abstract class Employee(val lastName: String, val baseSalary: Int) {
    abstract fun salary(): Int
    abstract val position: String
}

class Manager(lastName: String, baseSalary: Int, val bonus: Int) :
    Employee(lastName, baseSalary) {
    override val position = "manager"
    override fun salary() = baseSalary + bonus
}

class Developer(lastName: String, baseSalary: Int, val overtimeHours: Int) :
    Employee(lastName, baseSalary) {
    override val position = "developer"
    override fun salary() = baseSalary + overtimeHours * 1000
}

fun main() {
    println("=== Lesson 16. Practice: employee hierarchy ===")

    val staff = arrayOf(
        Manager("Ivanov", 80000, 10000),
        Developer("Petrov", 90000, 15),
        Developer("Sidorov", 80000, 0)
    )

    var payroll = 0
    for (employee in staff) {
        println("${employee.lastName} (${employee.position}): ${employee.salary()}")
        payroll += employee.salary()
    }
    println("Total payroll: $payroll")
}
