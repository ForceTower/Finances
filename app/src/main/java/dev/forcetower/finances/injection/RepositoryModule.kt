package dev.forcetower.finances.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.forcetower.finances.core.domain.repository.UserRepository
import dev.forcetower.finances.core.domain.repository.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun users(impl: UserRepositoryImpl): UserRepository
}