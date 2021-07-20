package com.example.resultapp

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import java.util.concurrent.Flow


class StudentRepository ( private val studentDao: StudentDAO)


{
    val allStudents = studentDao.getStudent()




    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createStudent(student: Student)  =
        studentDao.insertStudent(student)

    suspend fun updateStudents(student: Student)  =
        studentDao.updateStudent(student)

    suspend fun deleteStudents(student: Student)  =
        studentDao.deleteStudent(student)

    fun getStudent(): kotlinx.coroutines.flow.Flow<List<Student>> =
        studentDao.getStudent()

}