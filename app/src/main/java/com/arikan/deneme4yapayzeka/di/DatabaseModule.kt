package com.arikan.deneme4yapayzeka.di


import android.content.Context
import androidx.room.Room
import com.arikan.deneme4yapayzeka.data.local.database.AppDatabase
import com.arikan.deneme4yapayzeka.data.local.dao.ApartmentDao
import com.arikan.deneme4yapayzeka.data.local.dao.BuildingDao
import com.arikan.deneme4yapayzeka.data.local.dao.RoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "home_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideBuildingDao(appDatabase: AppDatabase): BuildingDao {
        return appDatabase.buildingDao()
    }

    @Provides
    fun provideApartmentDao(appDatabase: AppDatabase): ApartmentDao {
        return appDatabase.apartmentDao()
    }

    @Provides
    fun provideRoomDao(appDatabase: AppDatabase): RoomDao {
        return appDatabase.roomDao()
    }
}
