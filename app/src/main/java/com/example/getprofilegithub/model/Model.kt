package com.example.getprofilegithub.model

import android.text.Editable
import android.widget.TextView
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
