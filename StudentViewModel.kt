package com.example.resultapp

import androidx.lifecycle.*
import kotlinx.coroutines.launch


class StudentViewModel(private val studentRepository: StudentRepository) : ViewModel() {
    //insert new Student

    fun createStudent(
        studentRegNum: String,
        studentLevel: String,
        studentDepartment: String,
        studentName: String
    ) {
        val newStudent = getNewStudent(
            studentDepartment,
            studentLevel,
            studentName,
            studentRegNum
        )
        insertStudent(newStudent)
    }

    private fun insertStudent(student: Student) {
        viewModelScope.launch {
            studentRepository.createStudent(student)
        }
    }

    fun isEntryValid(
        studentName: String,
        studentLevel: String,
        studentRegNum: String,
        studentDepartment: String
    ): Boolean {
        if (studentName.isBlank() || studentLevel.isBlank() || studentRegNum.isBlank() || studentDepartment.isBlank()) {
            return false
        }
        return true
    }

    private fun getNewStudent(
        studentRegNum: String,
        studentLevel: String,
        studentName: String,
        studentDepartment: String,
    ): Student {
        return Student(
            studentName = studentName,
            studentRegNum = studentRegNum.toInt(),
            studentLevel = studentLevel.toInt(),
            studentDepartment = studentDepartment,
        )
    }
}
class StudentViewModelFactory(private val studentRepository: StudentRepository ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(studentRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}