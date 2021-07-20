package com.example.resultapp

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.concurrent.Flow


@Dao
interface  StudentDAO  {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertStudent(
        student:Student)
    @Query
        ("SELECT * FROM students")
    abstract fun getStudent(): kotlinx.coroutines.flow.Flow<List<Student>>

    @Update
    abstract fun updateStudent(student: Student)

    @Delete
   abstract fun deleteStudent(student: Student)


}