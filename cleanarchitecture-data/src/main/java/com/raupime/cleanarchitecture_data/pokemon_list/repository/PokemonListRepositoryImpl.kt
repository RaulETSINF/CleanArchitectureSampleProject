package com.raupime.cleanarchitecture_data.pokemon_list.repository

import com.raupime.cleanarchitecture_data.architecture.networking.constructUrl
import com.raupime.cleanarchitecture_data.architecture.networking.safeCall
import com.raupime.cleanarchitecture_data.pokemon_list.model.PokemonListDto
import com.raupime.cleanarchitecture_domain.architecture.util.NetworkError
import com.raupime.cleanarchitecture_domain.architecture.util.Result
import com.raupime.cleanarchitecture_domain.architecture.util.map
import com.raupime.cleanarchitecture_domain.pokemon_list.model.PokemonDomainModel
import com.raupime.cleanarchitecture_domain.pokemon_list.repository.PokemonListRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PokemonListRepositoryImpl(
    private val httpClient: HttpClient
) : PokemonListRepository {

    override suspend fun getPokemons(): Result<List<PokemonDomainModel>, NetworkError> {
        return safeCall<PokemonListDto> {
            httpClient.get(urlString = constructUrl("pokemon")){
                parameter("limit", 25)
                parameter("offset", 0)
            }
        }.map { response ->
            response.pokemonsList.map { it.toPokemonDomainModel() }
        }
    }
}