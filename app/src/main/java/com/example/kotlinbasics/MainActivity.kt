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

    display()

    while (!isDoneTakingOrder) {


        print("Enter your order: ")

        val myOrder = readLine()?.toInt()
        when (myOrder) {
            1 -> {
                order(165)
                if (orders.containsKey("Caffe Americano")) {
                    val currentValue = orders["Caffe Americano"]
                    if (currentValue != null) {
                        orders["Caffe Americano"] = currentValue + 1
                    } else {
                        print("error in taking orders")
                    }
                } else {
                    orders["Caffe Americano"] = 1
                }
            }

            2 -> {
                order(160)
                if (orders.containsKey("Caffe Latte")) {
                    val currentValue = orders["Caffe Latte"]
                    if (currentValue != null) {
                        orders["Caffe Latte"] = currentValue + 1
                    } else {
                        print("error in taking orders")
                    }
                } else {
                    orders["Caffe Latte"] = 1
                }
            }

            3 -> {
                order(160)
                if (orders.containsKey("Cappuccino")) {
                    val currentValue = orders["Cappuccino"]
                    if (currentValue != null) {
                        orders["Cappuccino"] = currentValue + 1
                    } else {
                        print("error in taking orders")
                    }
                } else {
                    orders["Cappuccino"] = 1
                }
            }

            4 -> {
                order(170)
                if (orders.containsKey("Caramel Macchiato")) {
                    val currentValue = orders["Caramel Macchiato"]
                    if (currentValue != null) {
                        orders["Caramel Macchiato"] = currentValue + 1
                    } else {
                        print("error in taking orders")
                    }
                } else {
                    orders["Caramel Macchiato"] = 1
                }
            }

            0 -> {
                println("\n\nYour order has been confirmed thank you for Ordering at KotlinBasics Cafe")
                println(
                    "---------- Receipt ----------\n" +
                            "Your Orders:"
                )
                for ((coffee, count) in orders) {
                    for ((coffe2, price) in productList) {
                        if (coffee == coffe2) {
                            val totalPrice = count * price
                            println("$coffee(x$count) - ₱$totalPrice")
                        }
                    }
                }
                println(
                    "Total:           ₱$totalSales\n" +
                            "-----------------------------"
                )
                generateReport()
                isDoneTakingOrder = true
            }

            else -> println("Please input an existing number in our menu")
        }
    }
}

//
fun order(cost: Int) {
    totalSales += cost
    totalOrders++
    averageSalePerOrder = totalSales / totalOrders
}

fun display() {
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





