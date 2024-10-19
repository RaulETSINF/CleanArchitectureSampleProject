package com.raupime.cleanarchitecture_data.pokemon_list.model


import com.raupime.cleanarchitecture_domain.pokemon_list.model.PokemonDomainModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(kotlinx.serialization.InternalSerializationApi::class)
@Serializable
data class PokemonDto(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
) {
    fun toPokemonDomainModel(): PokemonDomainModel {
        return PokemonDomainModel(
            name = name
        )
    }
}