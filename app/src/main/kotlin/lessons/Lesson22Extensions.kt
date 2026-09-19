/*
 * ============================================================================
 *  LESSON 22. EXTENSIONS (extension functions)
 *  Your own method on someone else's class, with no inheritance
 *  and no changes to the original source.
 * ============================================================================
 */
package lesson22

fun String.isEmail(): Boolean = this.contains("@") && this.contains(".")

fun Int.asPrice() = "$this USD"

fun String.firstWord() = this.trim().split(" ").firstOrNull() ?: ""

fun main() {
    println("=== Lesson 22. Extensions ===")

    println("test@mail.com".isEmail())    // true
    println("hello".isEmail())            // false
    println(450.asPrice())                // 450 USD
    println("Kirill Igorevich Novikov".firstWord())

    // Inside the function this is the object the method was called on.
    // Caveat: an extension cannot see private fields of the class
    // and cannot override existing methods.
}
