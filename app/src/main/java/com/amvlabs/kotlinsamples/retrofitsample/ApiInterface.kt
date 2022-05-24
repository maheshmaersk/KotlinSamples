package com.amvlabs.kotlinsamples.retrofitsample

import retrofit2.Call
import retrofit2.http.GET

public interface ApiInterface {

    @GET("/api/users?page=1")
    fun getUsersList(): Call<UserList>
}