package nl.dirkgroot.robotworlds.server

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class ResponseMessageTest {
    @Test
    fun `serialize to JSON`() {
        val json = ResponseMessage(result = "OK").toJSON()
        assertThat(json).isEqualTo("""{"result":"OK"}""")
    }
}
