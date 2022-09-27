package pe.edu.upc.moviedbcompose.ui.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upc.moviedbcompose.data.model.Movie
import pe.edu.upc.moviedbcompose.data.remote.ApiClient
import pe.edu.upc.moviedbcompose.data.remote.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()
    val movies get() = _movies

    val movieInterface = ApiClient.build()

    init{
        getPopularMovies()

    }
    fun getPopularMovies() {
        viewModelScope.launch {

            val getMovies = movieInterface.getPopularMovies()

            getMovies?.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    _movies.postValue(response.body()!!.results)
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.d("MoviesViewModel", t.toString())
                }

            })
        }
    }
}