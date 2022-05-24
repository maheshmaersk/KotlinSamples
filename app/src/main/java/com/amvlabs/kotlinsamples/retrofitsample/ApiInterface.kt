package com.amvlabs.kotlinsamples.retrofitsample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

public interface ApiInterface {

    @GET("/api/users?page=1")
    fun getUsersList(): Call<UserList>

    @GET
    fun getUsersDetails(@Url url: String): Call<UserDetails>
}