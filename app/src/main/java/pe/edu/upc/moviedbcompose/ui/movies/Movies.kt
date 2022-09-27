package pe.edu.upc.moviedbcompose.ui.movies

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
    Card(modifier = Modifier.padding(4.dp)) {
        Row {

            MovieImage(modifier = Modifier.weight(1f), movie)

            Column(modifier = Modifier
                .weight(7f)
                .padding(8.dp)) {
                Text(text = movie.title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = movie.overview, maxLines = 2)
            }

        }
    }
}


@Composable
fun MovieImage(modifier: Modifier, movie: Movie) {

    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
        contentDescription = null
    )
}
