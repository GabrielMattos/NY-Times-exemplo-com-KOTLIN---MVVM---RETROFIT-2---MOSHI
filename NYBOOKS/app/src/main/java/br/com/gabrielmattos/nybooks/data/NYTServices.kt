package br.com.gabrielmattos.nybooks.data

import br.com.gabrielmattos.nybooks.data.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface NYTServices
{
    @GET("lists.json")
    fun listRepos(): Call<List<>>
}