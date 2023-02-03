package com.example.getcep.model

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("logradouro")
    val address: String,
    @SerializedName("bairro")
    val neighbourhood: String,
    @SerializedName("localidade")
    val city: String,
    @SerializedName("uf")
    val state: String
)
