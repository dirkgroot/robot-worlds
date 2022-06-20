package nl.dirkgroot.robotworlds.client

import assertk.assertThat
import assertk.assertions.isEqualTo
import nl.dirkgroot.robotworlds.startServerApplication
import kotlin.test.Test

class SocketClientTest {
    @Test
    fun `invoke launch command with JSON message`() {
        val port = startServerApplication()
        val socketClient = SocketClient(port)
        val result = socketClient.send("""{ "command": "launch" }""")
        assertThat(result).isEqualTo("""{"result":"OK"}""")
    }
}
