package pe.edu.upc.moviedbcompose.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieInterface {

    @GET ("popular")
    fun getPopularMovies(@Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325"): Call<ApiResponse>

    @GET ("upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325",
                          @Query("page") page: Int, @Query("language") language: String): Call<ApiResponse>

    @GET ("top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325"): Call<ApiResponse>

    @GET("{category}")
    fun getMovies(@Path("category") category: String, @Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325")
}