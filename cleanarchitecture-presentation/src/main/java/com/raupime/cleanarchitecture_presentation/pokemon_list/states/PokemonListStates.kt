package com.raupime.cleanarchitecture_presentation.pokemon_list.states

import androidx.compose.runtime.Immutable
import com.raupime.cleanarchitecture_presentation.pokemon_list.model.PokemonPresentationModel


@Immutable
data class PokemonListStates(
    val isLoading: Boolean = false,
    val pokemonList: List<PokemonPresentationModel> = emptyList(),
    val error: String = ""
)
