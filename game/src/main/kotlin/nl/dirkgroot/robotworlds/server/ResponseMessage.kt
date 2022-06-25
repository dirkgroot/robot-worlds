package nl.dirkgroot.robotworlds.server

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class ResponseMessage(val result: String) {
    fun toJSON(): String {
        return Json.encodeToString(this)
    }
}
