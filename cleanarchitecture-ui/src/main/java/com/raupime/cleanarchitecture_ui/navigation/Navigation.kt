package com.raupime.cleanarchitecture_ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raupime.cleanarchitecture_presentation.pokemon_list.viewmodel.PokemonListViewModel
import com.raupime.cleanarchitecture_ui.pokemon_list.PokemonListScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    pokemonListViewModel: PokemonListViewModel = koinViewModel()
) {
    val pokemonListState by pokemonListViewModel.state.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = "PokemonList"
    ) {
        composable(route = "PokemonList") {
            PokemonListScreen(
                state = pokemonListState
            )
        }
    }
}