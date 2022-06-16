package nl.dirkgroot.robotworlds

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class RequestTest {
    @Test
    fun `create a request from JSON`() {
        val request = Request.fromJSON("""{ "command": "launch" }""")
        assertThat(request).isEqualTo(Request(command = "launch"))
    }
}
