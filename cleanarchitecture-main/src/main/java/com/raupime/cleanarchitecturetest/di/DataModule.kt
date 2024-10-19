package com.raupime.cleanarchitecturetest.di

import com.raupime.cleanarchitecture_data.architecture.networking.HttpClientFactory
import com.raupime.cleanarchitecture_data.pokemon_list.repository.PokemonListRepositoryImpl
import com.raupime.cleanarchitecture_domain.pokemon_list.repository.PokemonListRepository
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

var dataModule = module{
    single{ HttpClientFactory.create(CIO.create()) }
    singleOf(::PokemonListRepositoryImpl).bind<PokemonListRepository>()
}