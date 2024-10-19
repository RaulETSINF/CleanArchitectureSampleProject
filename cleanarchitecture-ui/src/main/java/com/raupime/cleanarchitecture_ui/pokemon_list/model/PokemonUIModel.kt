package com.raupime.cleanarchitecture_ui.pokemon_list.model

import com.raupime.cleanarchitecture_presentation.pokemon_list.model.PokemonPresentationModel

data class PokemonUIModel(
    val name: String
)

fun PokemonPresentationModel.toUiModel() = PokemonUIModel(
    name = name
)
