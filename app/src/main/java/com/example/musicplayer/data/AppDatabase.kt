package com.example.musicplayer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.musicplayer.data.model.Cancion

@Database(entities = [Cancion::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cancionDao(): CancionDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "canciones_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}