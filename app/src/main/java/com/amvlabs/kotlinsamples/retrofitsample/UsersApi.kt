package com.amvlabs.kotlinsamples.retrofitsample

import retrofit2.Response
import retrofit2.http.GET

interface UsersApi {

    @GET("api/users")
    suspend fun getUsers() : Response<UserList>
}