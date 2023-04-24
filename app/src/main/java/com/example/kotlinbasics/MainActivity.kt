var totalSales = 0
var totalOrders = 0
var averageSalePerOrder = 0
val orders: MutableMap<String, Int> = mutableMapOf()

const val CaffeAmericano = "Caffe Americano"
const val CaffeLatte = "Caffe Latte"
const val Cappuccino = "Cappuccino"
const val CaramelMacchiato = "Caramel Macchiato"

val productList = mapOf(
    CaffeAmericano to 165,
    CaffeLatte to 160,
    Cappuccino to 160,
    CaramelMacchiato to 170
)

fun main() {
    var isDoneTakingOrder = false

    displayMenu()

    while (!isDoneTakingOrder) {

        print("Enter your order: ")
        try{
            when (readLine()?.toInt()) {
                1 -> {
                    processOrder(165)
                    orderTracker("Caffe Americano")
                }

                2 -> {
                    processOrder(160)
                    orderTracker("Caffe Latte")
                }

                3 -> {
                    processOrder(160)
                    orderTracker("Cappuccino")
                }

                4 -> {
                    processOrder(170)
                    orderTracker("Caramel Macchiatto")
                }

                0 -> {
                    receiptPrinter()
                    generateReport()
                    isDoneTakingOrder = true
                }

                else -> println("Please input an existing number in our menu")
            }
        }catch(e: NumberFormatException){
            println("Please input numbers that are only shown in the menu")
        }
    }
}

//
fun processOrder(cost: Int) {
    totalSales += cost
    totalOrders++
    averageSalePerOrder = totalSales / totalOrders
}

fun displayMenu() {
    println("------ Kotlin Basics ------")
    println("Coffee Menu:")
    println("1 - Caffe Americano: ₱165\n2 - Caffe Latte: ₱160\n3 - Cappuccino: ₱160\n4 - Caramel Macchiato: ₱170 \n0 - Process Order")
    println("---------------------------")
    println("Type in the number of the coffee/s you want to order")
}

fun generateReport() {
    println("Sales Report: ")
    println("Total Sales: ₱$totalSales")
    println("Total Orders: #$totalOrders")
    println("Average Sale Per Order: ₱$averageSalePerOrder")
}
fun orderTracker(coffee: String){
    if (orders.containsKey(coffee)) {
        val currentValue = orders[coffee]
        if (currentValue != null) {
            orders[coffee] = currentValue + 1
        } else {
            print("error in taking orders")
        }
    } else {
        orders[coffee] = 1
    }
}

fun receiptPrinter(){
    println("\n\nYour order has been confirmed thank you for Ordering at KotlinBasics Cafe")
    println(
        "---------- Receipt ----------\n" +
                "Your Orders:"
    )
    for ((coffee, count) in orders) {
        for ((coffee2, price) in productList) {
            if (coffee == coffee2) {
                val totalPrice = count * price
                println("$coffee(x$count) - ₱$totalPrice")
            }
        }
    }
    println(
        "Total:           ₱$totalSales\n" +
                "-----------------------------"
    )
}



