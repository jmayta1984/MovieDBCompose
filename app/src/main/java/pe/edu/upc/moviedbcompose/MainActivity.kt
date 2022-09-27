package pe.edu.upc.moviedbcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.edu.upc.moviedbcompose.ui.movies.Movies
import pe.edu.upc.moviedbcompose.ui.movies.MoviesViewModel
import pe.edu.upc.moviedbcompose.ui.theme.MoviedbcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviedbcomposeTheme {
                // A surface container using the 'background' color from the theme
                val moviesViewModel: MoviesViewModel = viewModel()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Movies(moviesViewModel)
                }
            }
        }
    }
}

