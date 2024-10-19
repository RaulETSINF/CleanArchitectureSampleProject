package com.raupime.cleanarchitecturetest.di

import com.raupime.cleanarchitecture_presentation.pokemon_list.viewmodel.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

var presentationModule = module {
    viewModelOf(::PokemonListViewModel)
}