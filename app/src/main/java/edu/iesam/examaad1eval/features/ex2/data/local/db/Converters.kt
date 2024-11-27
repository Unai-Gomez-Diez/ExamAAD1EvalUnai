package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.Player

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromPlayerList(players: List<Player>): String {
        return gson.toJson(players)
    }

    @TypeConverter
    fun toPlayerList(json: String): List<Player> {
        return gson.fromJson(json, Array<Player>::class.java).toList()
    }

}