package com.raupime.cleanarchitecture_presentation.pokemon_list.model

import com.raupime.cleanarchitecture_domain.pokemon_list.model.PokemonDomainModel

data class PokemonPresentationModel(
    val name: String
)

fun PokemonDomainModel.toPresentationModel() = PokemonPresentationModel(
    name = name
)