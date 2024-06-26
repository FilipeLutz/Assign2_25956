package com.stu25956.assign2_25956

/**
 * CA2 - Movie Booking App
 * Filipe Lutz Mariano 25956
 */

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * This is a Composable function that represents the Home screen of the application.
 *
 * @param navController The NavController that this function uses to navigate between different screens.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {

    // Remember the list of movies
    val movies = remember { MovieList.movieList }

    // Scaffold that represents the Home screen
    Scaffold(
        // TopAppBar of the Home screen
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.LightGray,
                ),
                title = {

                    Row (
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth(0.87f)
                    ){

                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(40.dp)
                        )

                        Text(
                            "M O V I E S",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                }
            )
        },

        // BottomAppBar of the Home screen
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.LightGray
            ) {

            Text(
                "Filipe Lutz Mariano - 25956",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
                )
            }
        },

    ) {
        // LazyVerticalGrid that displays the list of movies
        LazyVerticalGrid(
            GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
            modifier = Modifier
                .background(Color.Black)
                .padding(
                    top = 63.dp,
                    bottom = 80.dp
                )

        ) {
            // items is a DSL function that places the given items into the grid.
            items(movies) { movie ->
                CardItems(movie = movie, navController = navController)
            }
        }
    }
}