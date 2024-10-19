package com.raupime.cleanarchitecturetest.di

import com.raupime.cleanarchitecture_domain.pokemon_list.usecase.GetPokemonsUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

var domainModule = module{
    singleOf(::GetPokemonsUseCase)
}