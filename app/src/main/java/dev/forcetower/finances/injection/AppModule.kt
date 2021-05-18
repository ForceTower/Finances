package dev.forcetower.finances.injection

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.forcetower.finances.core.source.local.FinanceDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun database(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FinanceDB::class.java, "finance.db")
            .enableMultiInstanceInvalidation()
            .fallbackToDestructiveMigration()
            .build()
}