package com.raupime.cleanarchitecture_ui.pokemon_list.components

import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.raupime.cleanarchitecture_ui.pokemon_list.model.PokemonUIModel

@Composable
fun PokemonListItem(
    modifier: Modifier = Modifier,
    pokemon: PokemonUIModel
) {
    ListItem(
        headlineContent = { Text(text = pokemon.name) },
    )
}

@PreviewLightDark
@Composable
private fun PokemonListItemPrev() {
    PokemonListItem(pokemon = pokemon)
}

internal val pokemon = PokemonUIModel(
    name = "Pikachu",
)