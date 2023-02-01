package com.example.loginroomdatabase.di.module

import android.app.Application
import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import com.example.loginroomdatabase.model.AppDatabase
import com.example.loginroomdatabase.model.UserDao
import com.example.loginroomdatabase.repository.UserRepository
import com.example.loginroomdatabase.ui.regiserpage.RegisterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object Test {
    fun modules() = repositorymodule + viewModelModule + userDb
}

val repositorymodule = module {
    single { UserRepository(get()) }
}

val viewModelModule = module {
    single { RegisterViewModel(get()) }
}

val userDb = module {
    fun provideDatabase(application: Application):AppDatabase{
        return Room.databaseBuilder(application,AppDatabase::class.java,"user_details")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(appDatabase: AppDatabase):UserDao{
        return appDatabase.UserDao()
    }
    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}

//val commonModule = module {
//    single<UserDao> {
//        UserDao()
//    }
//}