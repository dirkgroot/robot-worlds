package nl.dirkgroot.robotworlds

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import nl.dirkgroot.robotworlds.client.SocketClient
import nl.dirkgroot.robotworlds.server.startServerApplication
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.net.Socket
import java.time.Duration
import kotlin.test.Test

class ClientServerCommunicationTest {
    @Test
    fun `listens on free TCP port when no port is given`() {
        val port = startServerApplication()

        Socket("127.0.0.1", port).use {
            assertThat(it.isConnected).isTrue()
        }
    }

    @Test
    fun `client can send a command to server over a TCP socket`() {
        val port = startServerApplication()

        assertTimeoutPreemptively(Duration.ofSeconds(1)) {
            val response = SocketClient(port).send("""{ "command": "launch" }""")
            assertThat(response).isEqualTo("""{"result":"OK"}""")
        }
    }
}
