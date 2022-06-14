package nl.dirkgroot.robotworlds

class World {
    var robotCount: Int = 0
        private set

    fun launchRobot() {
        robotCount++
    }
}
