package com.amvlabs.kotlinsamples.retrofitsample

data class UserList(
    val page: Long,
    val perPage: Long,
    val total: Long,
    val totalPages: Long,
    val data: ArrayList<Datum>,
    val support: Support
)



// Camera, T2S, S2T , SharedPrefece , FirebaseCrashlytics, Messaging,