/*
 * ============================================================================
 *  LESSON 15. ABSTRACT CLASSES AND INTERFACES
 *
 *  Abstract class - "is a"   (a circle is a shape).
 *  Interface      - "can do" (a button can be clicked).
 * ============================================================================
 */
package lesson15

abstract class Shape {
    abstract fun area(): Double              // no body: subclasses must write it
    fun describe() = "Area: ${area()}"       // shared code for all subclasses
}

class Circle(val radius: Double) : Shape() {
    override fun area() = 3.14159 * radius * radius
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area() = width * height
}

interface Clickable {
    fun click()                                    // mandatory
    fun describe() = "the element is clickable"    // default implementation
}

interface Focusable {
    fun focus()
}

// only one class can be inherited, but any number of interfaces
class Button(val title: String) : Clickable, Focusable {
    override fun click() = println("Clicked $title")
    override fun focus() = println("Focus on $title")
}

fun main() {
    println("=== Lesson 15. Abstract classes and interfaces ===")

    // Shape()                      // ERROR: an abstract class cannot be created
    println(Circle(2.0).describe())
    println(Rectangle(3.0, 4.0).describe())

    val button = Button("Sign in")
    button.click()
    button.focus()
    println(button.describe())
}
