package com.raupime.cleanarchitecture_domain.pokemon_list.repository

import com.raupime.cleanarchitecture_domain.architecture.util.NetworkError
import com.raupime.cleanarchitecture_domain.architecture.util.Result
import com.raupime.cleanarchitecture_domain.pokemon_list.model.PokemonDomainModel

interface PokemonListRepository {
    suspend fun getPokemons(): Result<List<PokemonDomainModel> ,NetworkError>
}