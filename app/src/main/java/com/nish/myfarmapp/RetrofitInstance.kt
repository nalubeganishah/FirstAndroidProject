package com.nish.myfarmapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    fun createOkHttpClient():OkHttpClient {
        /**call interceptor*/
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }
    fun initialServices():AnimalInterface {
        /**call retrofit*/
        val okClient = createOkHttpClient()
        val retrofit = Retrofit.Builder().baseUrl("https://ivansfarm.000webhostapp.com/")
            .client(okClient).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(AnimalInterface::class.java )

    }
}