package dev.forcetower.finances.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.forcetower.finances.core.domain.repository.TransactionRepository
import dev.forcetower.finances.core.domain.repository.UserRepository
import dev.forcetower.finances.core.source.business.TransactionRepositoryImpl
import dev.forcetower.finances.core.source.business.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
    @Binds
    abstract fun bindTransactionRepository(impl: TransactionRepositoryImpl): TransactionRepository
}