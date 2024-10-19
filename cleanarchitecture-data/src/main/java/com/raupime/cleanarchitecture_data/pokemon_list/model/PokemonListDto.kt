package com.raupime.cleanarchitecture_data.pokemon_list.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@OptIn(kotlinx.serialization.InternalSerializationApi::class)
@Serializable
data class PokemonListDto(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("results")
    val pokemonsList: List<PokemonDto>
)
