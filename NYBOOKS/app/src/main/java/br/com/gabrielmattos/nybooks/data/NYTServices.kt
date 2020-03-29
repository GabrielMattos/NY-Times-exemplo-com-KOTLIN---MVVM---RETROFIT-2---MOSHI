package br.com.gabrielmattos.nybooks.data

import br.com.gabrielmattos.nybooks.data.model.Book
import br.com.gabrielmattos.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices
{
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey:String = "13pbqWJpItICGri9WCLQI7CdW0uluZGI",
        @Query("list") list:String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}