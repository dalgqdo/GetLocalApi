package com.example.latihanapi

import android.os.Bundle
import android.util.Log.e
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanapi.Adapter.ItemAdapter
import com.example.latihanapi.Utilities.APIClient
import com.example.latihanapi.Utilities.APIInterface
import com.example.latihanapi.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcView.layoutManager = LinearLayoutManager(this)
        btnRefresh.setOnClickListener {
            getData()
        }
    }


    private fun getData() {
        val apiInterface = APIClient().getClient().create(APIInterface::class.java)
        apiInterface.getItem().enqueue(object : Callback<ArrayList<Item>> {
            override fun onFailure(call: Call<ArrayList<Item>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Error Connection", Toast.LENGTH_SHORT).show()
                e("Error", t!!.message, t)
            }

            override fun onResponse(call: Call<ArrayList<Item>>?, response: Response<ArrayList<Item>>?) {
                if (response!!.code() == 200) {
                    rcView.adapter = ItemAdapter(this@MainActivity, response.body()!!)
                } else {
                    Toast.makeText(this@MainActivity, "Error Server", Toast.LENGTH_SHORT).show()
                    e("Error", "Error Server")
                }
            }


        })
    }
}
