/*
 * ============================================================================
 *  LESSON 14. VISIBILITY MODIFIERS
 *
 *  public     - from everywhere (the default, may be omitted)
 *  private    - only inside this class or file
 *  protected  - inside the class and its subclasses
 *  internal   - inside the same compilation module
 * ============================================================================
 */
package lesson14

open class Vehicle(protected val engineBrand: String) {
    private val serialNumber = "SN-12345"       // hidden even from subclasses

    fun describe() = "Engine $engineBrand, serial $serialNumber"
}

class Car(brand: String) : Vehicle(brand) {
    fun check(): String {
        // println(serialNumber)                 // ERROR: private
        return "Checking $engineBrand"           // ok: protected
    }
}

fun main() {
    println("=== Lesson 14. Visibility modifiers ===")

    val car = Car("Toyota")
    println(car.check())
    println(car.describe())
    // println(car.engineBrand)                  // ERROR: protected
}
