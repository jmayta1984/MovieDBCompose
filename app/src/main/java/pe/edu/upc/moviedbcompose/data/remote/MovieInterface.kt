package pe.edu.upc.moviedbcompose.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET ("popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<ApiResponse>
}