package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos") // base_url/photos GET
    suspend fun getPhotos() : String // Where is the implementation??
}
// Retrofit hides way too much details

// object: singleton object
object MarsApi {
    val retrofitService: MarsApiService by lazy { // lazy for lazy initialization
        retrofit.create(MarsApiService::class.java) // What is supposed to be created here?
    }
}