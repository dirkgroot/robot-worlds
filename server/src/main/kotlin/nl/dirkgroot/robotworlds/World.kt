package nl.dirkgroot.robotworlds

class World {
    var robotCount: Int = 0
        private set

    fun handleRequest(request: Request) {
        launchRobot()
    }

    fun launchRobot() {
        robotCount++
    }
}
