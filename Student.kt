package com.example.resultapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "students")
data class Student(

        @PrimaryKey
        @ColumnInfo(name = "regNum")
        val studentRegNum: Int,
        @ColumnInfo(name = "name")
        val studentName: String?,
        @ColumnInfo(name = "department")
        val studentDepartment: String?,
        @ColumnInfo(name = "level")
        val studentLevel: Int,
        )

