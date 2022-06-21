package nl.dirkgroot.robotworlds.server

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class CommandResultTest {
    @Test
    fun `serialize to JSON`() {
        val json = CommandResult(result = "OK").toJSON()
        assertThat(json).isEqualTo("""{"result":"OK"}""")
    }
}
