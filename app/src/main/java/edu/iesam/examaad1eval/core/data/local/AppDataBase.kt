package edu.iesam.examaad1eval.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.db.Converters
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun gameDao(): GameDao

}