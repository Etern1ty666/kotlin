/*
 * ============================================================================
 *  LESSON 20. POLYMORPHISM
 *  The variable is declared with the parent type, but the subclass method runs.
 *  The decision is made at runtime.
 * ============================================================================
 */
package lesson20

// the same hierarchy as in lesson 15 - each lesson file stands on its own
abstract class Shape {
    abstract fun area(): Double
    fun describe() = "Area: ${area()}"
}

class Circle(val radius: Double) : Shape() {
    override fun area() = 3.14159 * radius * radius
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area() = width * height
}

fun inspect(shape: Shape) {
    // --- is: type check plus smart cast ---
    if (shape is Circle) {
        println("Radius: ${shape.radius}")   // inside the branch it is a Circle
    }

    // --- when by type ---
    when (shape) {
        is Circle -> println("circle of radius ${shape.radius}")
        is Rectangle -> println("rectangle")
        else -> println("some other shape")
    }

    // --- as and as? ---
    val asRectangle = shape as? Rectangle    // wrong type gives null
    println("As rectangle: $asRectangle")
    // val forced = shape as Rectangle       // wrong type would crash
}

fun main() {
    println("=== Lesson 20. Polymorphism ===")

    val shapes: Array<Shape> = arrayOf(
        Circle(2.0),
        Rectangle(3.0, 4.0),
        Circle(1.0)
    )

    // the loop does not know which shapes are inside.
    // Add a Triangle later and the loop stays untouched.
    for (shape in shapes) {
        println(shape.area())
    }

    inspect(Circle(5.0))
    inspect(Rectangle(2.0, 2.0))
}
