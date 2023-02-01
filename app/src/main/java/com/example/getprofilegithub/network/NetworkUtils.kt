package com.example.getprofilegithub.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    companion object {
        private const val URL_BASE: String = "https://viacep.com.br"
        fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}