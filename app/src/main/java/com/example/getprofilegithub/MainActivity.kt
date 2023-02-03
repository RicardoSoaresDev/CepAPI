package com.example.getprofilegithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.getprofilegithub.model.Model
import com.example.getprofilegithub.network.EndPointPath
import com.example.getprofilegithub.network.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var address: EditText
    private lateinit var neighbourhood: EditText
    private lateinit var city: EditText
    private lateinit var state: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        address = findViewById(R.id.address)
        neighbourhood = findViewById(R.id.neighbourhood)
        city = findViewById(R.id.city)
        state = findViewById(R.id.state)
        button = findViewById(R.id.button1)

        button.setOnClickListener {

            getData(address, neighbourhood, city, state)

        }
    }

    private fun getData(address: EditText, neighbourhood: EditText, city: EditText, state: EditText) {

        val retrofitBase = NetworkUtils.getRetrofitInstance()
        val endPointPath = retrofitBase.create(EndPointPath::class.java)
        val cep = findViewById<EditText>(R.id.cep).text
        val callback = endPointPath.getAddress(cep.toString())

        callback.enqueue(object: Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {

                address.setText(response.body()?.address).toString()
                neighbourhood.setText(response.body()?.neighbourhood).toString()
                city.setText(response.body()?.city).toString()
                state.setText(response.body()?.state).toString()

//                Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Erro", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
