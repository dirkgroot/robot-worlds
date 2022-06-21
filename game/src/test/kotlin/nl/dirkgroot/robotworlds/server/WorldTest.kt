package nl.dirkgroot.robotworlds.server

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isZero
import kotlin.test.Test

class WorldTest {
    @Test
    fun `no robots in a new world`() {
        val world = World()
        assertThat(world.robotCount).isZero()
    }

    @Test
    fun `launch a robot into the world`() {
        val world = World()
        world.launchRobot()
        assertThat(world.robotCount).isEqualTo(1)
    }
}
