package nl.dirkgroot.robotworlds

class MessageReceiver(private val world: World) {
    fun receive(jsonMessage: String): String {
        val request = Request.fromJSON(jsonMessage)
        return handleRequest(request).toJSON()
    }

    private fun handleRequest(request: Request): CommandResult {
        world.launchRobot()
        return CommandResult(result = "OK")
    }
}
