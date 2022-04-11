package com.luka.travel.di

import com.luka.travel.network.DestinationService
import com.luka.travel.repository.DestinationsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

//    @Provides
//    @ViewModelScoped
//    fun provideRepository(
//        pokedexService: PokedexService
//    ): LocationRepository {
//
//        return LocationRepository(pokedexService)
//    }


    @Provides
    @ViewModelScoped
    fun provideDestinationRepository(
        destinationService: DestinationService
    ): DestinationsRepository {
        return DestinationsRepository(destinationService)
    }
}

