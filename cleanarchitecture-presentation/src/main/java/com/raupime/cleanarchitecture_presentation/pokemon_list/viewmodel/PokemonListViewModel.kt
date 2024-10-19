package com.raupime.cleanarchitecture_presentation.pokemon_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raupime.cleanarchitecture_domain.architecture.util.onError
import com.raupime.cleanarchitecture_domain.architecture.util.onSuccess
import com.raupime.cleanarchitecture_domain.pokemon_list.usecase.GetPokemonsUseCase
import com.raupime.cleanarchitecture_presentation.pokemon_list.model.toPresentationModel
import com.raupime.cleanarchitecture_presentation.pokemon_list.states.PokemonListStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonListStates())
    val state = _state
        .onStart { getPokemonList() }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PokemonListStates())

    fun getPokemonList() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            getPokemonListUseCase()
                .onSuccess { pokemonList ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            pokemonList = pokemonList.map{ it.toPresentationModel() }
                        )
                    }
                }
                .onError {
                    _state.update {
                        it.copy(isLoading = false)
                    }
                }
        }
    }
}