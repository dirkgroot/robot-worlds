package nl.dirkgroot.robotworlds.server

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class RequestMessage(val command: String) {
    companion object {
        fun fromJSON(json: String): RequestMessage {
            return Json.decodeFromString(json)
        }
    }
}
