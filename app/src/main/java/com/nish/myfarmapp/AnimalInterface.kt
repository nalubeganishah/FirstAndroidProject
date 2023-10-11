package com.nish.myfarmapp

import retrofit2.http.GET

/**create interface for our retrofit*/
interface AnimalInterface {
    @GET("api/get_animals.php")
    suspend fun getAnimals():AnimalResponse
}