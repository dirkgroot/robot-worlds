package nl.dirkgroot.robotworlds

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class CommandResult(val result: String) {
    fun toJSON(): String {
        return Json.encodeToString(this)
    }
}
