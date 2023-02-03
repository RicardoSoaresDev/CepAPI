package com.example.getcep.network

import com.example.getcep.model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPointPath {
    @GET("/ws/{cep}/json")
    fun getAddress(
        @Path("cep")
        cep: String
    ) : Call<Model>
}