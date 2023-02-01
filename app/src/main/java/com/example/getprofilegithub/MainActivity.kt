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

    private var address: EditText? = null
    private var neighbourhood: EditText? = null
    private var city: EditText? = null
    private var state: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val cep = findViewById<EditText>(R.id.cep)

//        val address = findViewById<TextView>(R.id.address)
//        val neighbourhood = findViewById<EditText>(R.id.neighbourhood)
//        val city = findViewById<EditText>(R.id.city)
//        val state = findViewById<EditText>(R.id.state)

        val button = findViewById<Button>(R.id.button1)

        button.setOnClickListener {

            getData(address, neighbourhood, city, state)

        }
    }

    private fun getData(address: EditText?, neighbourhood: EditText?, city: EditText?, state: EditText?) {

        val retrofitBase = NetworkUtils.getRetrofitInstance()
        val endPointPath = retrofitBase.create(EndPointPath::class.java)
        val cep = findViewById<EditText>(R.id.cep).text
        val callback = endPointPath.getAddress(cep.toString())

        callback.enqueue(object: Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {

                address?.setText(response.body()?.address)
                neighbourhood?.setText(response.body()?.neighbourhood)
                city?.setText(response.body()?.city)
                state?.setText(response.body()?.state)

                Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Erro", Toast.LENGTH_SHORT).show()

                println("$t, >>>>>>>>>>>>>")
            }
        })
    }
}



//                address.text = response.body()?.Address
//                neighbourhood.text = response.body()?.neighbourhood
//                city.text = response.body()?.city
//                state.text = response.body()?.state