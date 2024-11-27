package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.Player

const val GAME_TABLE_NAME = "games"

@Entity(tableName = GAME_TABLE_NAME)
data class GameEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "player") val player: List<Player>
)