package com.example.resultapp

import android.app.Application


class ResultApplication: Application() {


    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}