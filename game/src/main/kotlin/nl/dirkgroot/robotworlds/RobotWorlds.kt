package nl.dirkgroot.robotworlds

import nl.dirkgroot.robotworlds.client.Robot
import nl.dirkgroot.robotworlds.client.SocketClient
import nl.dirkgroot.robotworlds.server.startServerApplication
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty())
        notEnoughArguments()

    when (args[0]) {
        "server" -> runServer()
        "client" -> {
            if (args.size < 2)
                notEnoughArguments()

            runClient(args[1].toInt())
        }
    }
}

private fun notEnoughArguments() {
    System.err.println("Not enough arguments!")
    exitProcess(1)
}

private fun runServer() {
    val port = startServerApplication()
    println("Server running on port $port")
}

private fun runClient(port: Int) {
    println("Connecting to server on port $port...")
    Robot(SocketClient(port)).launch()
    println("Robot launched!")
}
