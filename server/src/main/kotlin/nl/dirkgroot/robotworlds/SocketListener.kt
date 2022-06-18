package nl.dirkgroot.robotworlds

import java.net.ServerSocket
import java.net.Socket

class SocketListener(private val messageReceiver: MessageReceiver) {
    private val serverSocket = ServerSocket(0)

    val port get() = serverSocket.localPort

    init {
        Thread {
            serverSocket.accept().use { socket ->
                val request = receiveRequest(socket)
                val response = messageReceiver.receive(request)

                sendResponse(socket, response)
            }
        }.start()
    }

    private fun receiveRequest(socket: Socket) =
        socket.getInputStream().bufferedReader().readLine()

    private fun sendResponse(socket: Socket, response: String) {
        socket.getOutputStream().writer().apply {
            write("$response\n")
            flush()
        }
    }
}
