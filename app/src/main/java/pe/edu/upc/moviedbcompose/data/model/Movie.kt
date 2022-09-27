package pe.edu.upc.moviedbcompose.data.model

import com.google.gson.annotations.SerializedName

class Movie(

    val id: Int,
    val title: String,
    val overview: String,

    @SerializedName("poster_path")
    val posterPath: String
)