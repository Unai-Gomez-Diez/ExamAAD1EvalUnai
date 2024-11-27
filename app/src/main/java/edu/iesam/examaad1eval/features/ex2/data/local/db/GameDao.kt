package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {
    @Query("SELECT * FROM $GAME_TABLE_NAME")
    fun getAll(): List<GameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg games: GameEntity)

    @Query("DELETE FROM $GAME_TABLE_NAME")
    fun deleteAll()


}