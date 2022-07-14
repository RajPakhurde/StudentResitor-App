package com.example.studentresitration.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class StudentDatabase:RoomDatabase() {
    abstract fun studentDao() :StudentDao
    companion object{
        @Volatile
        private var INSTANCE : StudentDatabase? = null
        fun getInstance(context: Context): StudentDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDatabase::class.java,
                        "Student_data_database"
                    ).build()
                }
                return instance
            }
        }

    }

}