package com.raupime.cleanarchitecture_domain.pokemon_list.usecase

import com.raupime.cleanarchitecture_domain.architecture.util.NetworkError
import com.raupime.cleanarchitecture_domain.architecture.util.Result
import com.raupime.cleanarchitecture_domain.pokemon_list.model.PokemonDomainModel
import com.raupime.cleanarchitecture_domain.pokemon_list.repository.PokemonListRepository

class GetPokemonsUseCase(
    private val pokemonListRepository: PokemonListRepository
) {
    suspend operator fun invoke(): Result<List<PokemonDomainModel>, NetworkError> {
        return  pokemonListRepository.getPokemons()
    }
}