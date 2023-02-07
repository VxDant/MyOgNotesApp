package com.example.notesapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesapp.data.local.model.Notes


@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteObject: Notes)

    @Update
    suspend fun updateNote(noteObject: Notes)

    @Query(value = "DELETE FROM recentNotesTable WHERE id= :id ")
    fun deleteNote(id: Int)

    @Query(value = "SELECT * FROM recentNotesTable")
    fun getNotes(): LiveData<List<Notes>>

    @Query(value = "SELECT * FROM recentNotesTable WHERE priority = :priorityConstant")
    fun getFilteredPriorityNotes(priorityConstant: String): LiveData<List<Notes>>


}