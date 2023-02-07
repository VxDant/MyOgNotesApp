package com.example.notesapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.data.local.dao.NotesDao
import com.example.notesapp.data.local.model.Notes


@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao() : NotesDao

    companion object {
        @Volatile
        private var instance: NotesDatabase? = null
        fun getDatabase(context: Context): NotesDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDatabase::class.java,
                        "NotesDB"
                    ).build()
                }
            }

            return instance!!
        }
    }



}