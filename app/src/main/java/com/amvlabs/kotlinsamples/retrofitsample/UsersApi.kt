package com.amvlabs.kotlinsamples.retrofitsample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersApi {

    @GET("api/users")
    suspend fun getUsers() : Response<UserList>


    @POST("api/users")
    suspend fun addUsers() : Response<UserList>
}