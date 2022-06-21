package nl.dirkgroot.robotworlds.server

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.net.Socket
import java.time.Duration
import kotlin.test.Test

class SocketListenerTest {
    @Test
    fun `listens on free TCP port when no port is given`() {
        val socketListener = SocketListener(MessageReceiver(World()))
        val port = socketListener.port

        Socket("127.0.0.1", port).use {
            assertThat(it.isConnected).isTrue()
        }
    }

    @Test
    fun `handles a command`() {
        val socketListener = SocketListener(MessageReceiver(World()))
        val port = socketListener.port

        assertTimeoutPreemptively(Duration.ofSeconds(1)) {
            Socket("127.0.0.1", port).use { socket ->
                sendLaunchCommand(socket)
                val response = receiveResponse(socket)

                assertThat(response).isEqualTo("""{"result":"OK"}""")
            }
        }
    }

    private fun sendLaunchCommand(socket: Socket) {
        socket.getOutputStream().writer().apply {
            write("""{ "command": "launch" }""" + "\n")
            flush()
        }
    }

    private fun receiveResponse(socket: Socket) =
        socket.getInputStream().bufferedReader().readLine()
}
