package com.debcomp.aql.sp42.feature.home.data.service

import com.debcomp.aql.sp42.feature.home.model.entity.Cadet
import com.debcomp.aql.sp42.feature.home.model.entity.User
import com.debcomp.aql.sp42.infra.Constants
import retrofit2.Call
import retrofit2.http.*

/*
 * Davi Áquila
 * aquiladvx
 *
 * 19/12/2020
 *
 */
interface HomeService {

    @Headers("Authorization: " + Constants.AUTH)
    @GET("users/{user_id}")
    fun getCadetById(
            @Path(value = "user_id") userId: String
    ): Call<Cadet>

    @Headers("Authorization: " + Constants.AUTH)
    @GET("campus/20/users?per_page=100&sort=id")
    fun getAllCadets(
            @Query("page")page: Int
    ) : Call<List<User>>

//    @GET("discover/tv")
//    fun getShowByGenre(
//            @Query("api_key")apiKey: String,
//            @Query("language")language: String = "pt-BR",
//            @Query("with_genres")genreId: Int
//    ): Call<ShowList>

//    //Post example with param
//    @POST("user")
//    suspend fun getUser(
//        @Query("id")id: Int
//    ): Response<List<User>>
//
//    //Post example with body
//    @POST("user/new")
//    suspend fun registerUser(
//        @Body user: User
//    ): Response<List<User>>
}