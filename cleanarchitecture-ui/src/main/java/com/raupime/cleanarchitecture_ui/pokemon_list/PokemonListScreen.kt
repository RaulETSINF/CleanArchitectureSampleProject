package com.raupime.cleanarchitecture_ui.pokemon_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.raupime.cleanarchitecture_presentation.pokemon_list.model.PokemonPresentationModel
import com.raupime.cleanarchitecture_presentation.pokemon_list.states.PokemonListStates
import com.raupime.cleanarchitecture_ui.pokemon_list.components.PokemonListItem
import com.raupime.cleanarchitecture_ui.pokemon_list.model.toUiModel
import com.raupime.cleanarchitecture_ui.theme.CleanArchitectureTestTheme

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    state: PokemonListStates,
) {
    Scaffold { innerPadding ->
        if (state.isLoading) {
            Box(
                modifier = modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                LazyColumn {
                    items(state.pokemonList) { pokemon ->
                        PokemonListItem(pokemon = pokemon.toUiModel())
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PokemonListScreenPrev() {
    CleanArchitectureTestTheme {
        PokemonListScreen(
            state = PokemonListStates(
                isLoading = false,
                pokemonList = (1..100).map {
                    PokemonPresentationModel(
                        name = "POKEMON $it"
                    )
                }
            )
        )
    }
}