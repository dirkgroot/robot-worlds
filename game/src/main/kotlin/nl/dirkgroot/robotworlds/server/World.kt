package nl.dirkgroot.robotworlds.server

class World {
    var robotCount: Int = 0
        private set

    fun launchRobot() {
        robotCount++
    }
}
