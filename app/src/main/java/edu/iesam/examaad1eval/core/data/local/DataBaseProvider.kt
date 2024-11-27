package edu.iesam.examaad1eval.core.data.local

import android.content.Context
import androidx.room.Room

object DataBaseProvider {
    fun provideDataBase(context: Context): AppDataBase {
        val db = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "db-exam"
        )
        return db.build()
    }
}