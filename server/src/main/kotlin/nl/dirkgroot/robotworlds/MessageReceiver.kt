package nl.dirkgroot.robotworlds

class MessageReceiver(private val world: World) {
    fun receive(jsonMessage: String): String {
        val request = Request.fromJSON(jsonMessage)
        return world.handleRequest(request).toJSON()
    }
}
