package com.example.latihanapi.Utilities

import com.example.latihanapi.model.Item
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface APIInterface {

    @GET("testing")
    fun getItem(): Call<ArrayList<Item>>
}