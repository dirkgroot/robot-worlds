package nl.dirkgroot.robotworlds.client

import java.net.Socket

class SocketClient(private val port: Int) {
    fun send(message: String): String {
        return Socket("127.0.0.1", port).use {
            sendMessage(it, message)
            receiveResponse(it)
        }
    }

    private fun sendMessage(socket: Socket, message: String) {
        socket.getOutputStream().writer().apply {
            write("$message\n")
            flush()
        }
    }

    private fun receiveResponse(socket: Socket) =
        socket.getInputStream().bufferedReader().readLine()
}
