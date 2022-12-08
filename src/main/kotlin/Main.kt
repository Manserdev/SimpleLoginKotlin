import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    mainMenu()
}

fun mainMenu() {

    println("Please make a selection: ")
    println(" 1: Login \n 2: Register \n 3: Exit")
    val userInput = readln().toInt()

    when (userInput) {
        1 -> loginPage()
        2 -> registerPage()
        3 -> exitProcess(0)
        else -> mainMenu()

    }
}

fun loginPage() {


    println("Please enter a username: ")
    val input1 = readln()
    println("Please enter password: ")
    val input2 = readln()
    val login = "$input1 $input2"

    val accounts = mutableListOf<String>()

    val fileName = "/home/tim/IdeaProjects/test1/src/main/kotlin/accountDetails.txt"
    File(fileName).useLines { lines -> accounts.addAll(lines) }


    if (accounts.contains(login)) {

        println("You have successfully logged in, please make a selection: ")
        println("1: Print users \n 2: Logout")
        var selection = readln().toInt()

        when (selection) {
            1 -> readFileLineByLineUsingForEachLine("/home/tim/IdeaProjects/test1/src/main/kotlin/accountDetails.txt")
            2 -> mainMenu()
        }

    } else {
        println("Account doesnt exist.")
        loginPage()
    }


}

fun registerPage() {

    println("Please enter a username: ")
    val input1 = readln()
    println("Please enter password: ")
    val input2 = readln()

    val aL = LoginCredentials(input1, input2)

    val fileName = "/home/tim/IdeaProjects/test1/src/main/kotlin/accountDetails.txt"
    val myFile = File(fileName)

    myFile.printWriter().use { out ->

        out.println(aL.account)
    }

    mainMenu()
}

fun readFileLineByLineUsingForEachLine(fileName: String) = File(fileName).forEachLine { println(it) }


class LoginCredentials(var username: String, var password: String) {

    var account = "$username $password"
}