package pe.edu.upc.moviedbcompose.ui.movies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import pe.edu.upc.moviedbcompose.data.model.Movie

@Composable
fun Movies(viewModel: MoviesViewModel) {

    val movies: List<Movie> by viewModel.movies.observeAsState(listOf())

    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie)
        }
    }
}

@Composable
fun MovieRow(movie: Movie) {
    Row {
        Column(modifier = Modifier.weight(7f)) {
            Text(text = movie.title)
            Text(text = movie.overview)
        }
        MovieImage(modifier = Modifier.weight(1f), movie)
    }
}

@Composable
fun MovieImage(modifier: Modifier, movie: Movie) {
}
