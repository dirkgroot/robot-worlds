package nl.dirkgroot.robotworlds.server

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class Request(val command: String) {
    companion object {
        fun fromJSON(json: String): Request {
            return Json.decodeFromString(json)
        }
    }
}
