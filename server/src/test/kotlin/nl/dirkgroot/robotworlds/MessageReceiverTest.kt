package nl.dirkgroot.robotworlds

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class MessageReceiverTest {
    @Test
    fun `invoke launch command with JSON message`() {
        val world = World()
        val messageReceiver = MessageReceiver(world)
        val result = messageReceiver.receive("""{ "command": "launch" }""")
        assertThat(world.robotCount).isEqualTo(1)
        assertThat(result).isEqualTo("""{"result":"OK"}""")
    }
}
