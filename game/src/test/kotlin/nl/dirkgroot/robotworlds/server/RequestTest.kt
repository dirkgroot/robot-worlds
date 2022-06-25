package nl.dirkgroot.robotworlds.server

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class RequestTest {
    @Test
    fun `create a request from JSON`() {
        val requestMessage = RequestMessage.fromJSON("""{ "command": "launch" }""")
        assertThat(requestMessage).isEqualTo(RequestMessage(command = "launch"))
    }
}
