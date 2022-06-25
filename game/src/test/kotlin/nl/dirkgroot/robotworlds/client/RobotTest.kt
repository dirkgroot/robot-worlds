package nl.dirkgroot.robotworlds.client

import assertk.assertThat
import assertk.assertions.isFailure
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import nl.dirkgroot.robotworlds.server.startServerApplication
import kotlin.test.Test

class RobotTest {
    @Test
    fun `initially not launched`() {
        val port = startServerApplication()
        val client = SocketClient(port)
        val robot = Robot(client)
        assertThat(robot.launched).isFalse()
    }

    @Test
    fun `launch the robot`() {
        val port = startServerApplication()
        val client = SocketClient(port)
        val robot = Robot(client)
        robot.launch()
        assertThat(robot.launched).isTrue()
    }

    @Test
    fun `launch when the server is not running`() {
        val client = SocketClient(32323)
        val robot = Robot(client)
        assertThat { robot.launch() }.isFailure()
        assertThat(robot.launched).isFalse()
    }
}
