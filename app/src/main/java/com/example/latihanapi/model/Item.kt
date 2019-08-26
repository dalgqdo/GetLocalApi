package com.example.latihanapi.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id") val id: Int,
    @SerializedName("item_name") val name: String,
    @SerializedName("item_size") val size: String,
    @SerializedName("item_color") val color: String
)

