package nl.dirkgroot.robotworlds.client

import nl.dirkgroot.robotworlds.server.RequestMessage

class Robot(private val client: SocketClient) {
    var launched: Boolean = false
        private set

    fun launch() {
        client.send(RequestMessage("launch").toJSON())
        launched = true
    }
}
