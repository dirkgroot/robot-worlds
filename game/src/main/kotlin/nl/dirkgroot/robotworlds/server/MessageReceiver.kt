package nl.dirkgroot.robotworlds.server

class MessageReceiver(private val world: World) {
    fun receive(jsonMessage: String): String {
        val requestMessage = RequestMessage.fromJSON(jsonMessage)
        return handleRequest(requestMessage).toJSON()
    }

    private fun handleRequest(requestMessage: RequestMessage): ResponseMessage {
        world.launchRobot()
        return ResponseMessage(result = "OK")
    }
}
