/*
 * ============================================================================
 *  LESSON 25. ENCAPSULATION
 *  An object is responsible for keeping its own data valid.
 * ============================================================================
 */
package lesson25

class Account(val owner: String) {

    // readable from the outside, not writable
    var balance: Int = 0
        private set

    // validation right inside the setter. field is the backing storage
    // of the property and can only be touched inside get and set.
    var pin: String = "0000"
        set(value) {
            if (value.length == 4) field = value
            else println("The PIN must be 4 characters long")
        }

    fun deposit(amount: Int) {
        if (amount > 0) balance += amount
    }

    fun withdraw(amount: Int): Boolean {
        if (amount <= 0 || amount > balance) return false
        balance -= amount
        return true
    }
}

fun main() {
    println("=== Lesson 25. Encapsulation ===")

    val account = Account("Anna")
    // account.balance = 1000000        // ERROR: only through deposit()

    account.deposit(5000)
    println(account.balance)            // 5000

    println(account.withdraw(1000))     // true
    println(account.withdraw(999999))   // false - the check is inside
    println(account.balance)            // 4000

    account.pin = "12"                  // fails validation
    account.pin = "1234"                // ok
    println(account.pin)
    println("Owner: ${account.owner}")
}
