/*
 * ============================================================================
 *  LESSON 13. INHERITANCE
 *  Everything is closed by default in Kotlin: you need open.
 * ============================================================================
 */
package lesson13

open class Animal(val nickname: String) {
    open fun voice() = "..."
    open fun info() = "Animal $nickname"
}

// the colon means inheritance, the parentheses call the parent constructor
class Dog(nickname: String, val breed: String) : Animal(nickname) {
    override fun voice() = "Woof"

    // super - access to the parent implementation
    override fun info() = super.info() + ", breed $breed"
}

class Cat(nickname: String) : Animal(nickname) {
    override fun voice() = "Meow"
}

fun main() {
    println("=== Lesson 13. Inheritance ===")

    val pets = arrayOf(Dog("Rex", "husky"), Cat("Murka"))
    for (pet in pets) {
        println("${pet.nickname}: ${pet.voice()}")
    }

    println(Dog("Rex", "husky").info())
}
