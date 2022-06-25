package nl.dirkgroot.robotworlds.server

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class MessageHandlerTest {
    @Test
    fun `invoke launch command with JSON message`() {
        val world = World()
        val messageHandler = MessageHandler(world)
        val result = messageHandler.receive("""{ "command": "launch" }""")
        assertThat(world.robotCount).isEqualTo(1)
        assertThat(result).isEqualTo("""{"result":"OK"}""")
    }
}
