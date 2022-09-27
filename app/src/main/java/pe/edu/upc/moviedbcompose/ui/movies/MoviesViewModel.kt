package pe.edu.upc.moviedbcompose.ui.movies

import androidx.lifecycle.MutableLiveData
import pe.edu.upc.moviedbcompose.data.model.Movie

class MoviesViewModel {

    private var _movies= MutableLiveData<List<Movie>>()
    val movies get() = _movies
}