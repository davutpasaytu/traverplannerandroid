package com.barisemrealanc.travelplanner

data class LocalPost(
    val profileName: String,
    val postDate: String,
    val description: String,
    val location: String,
    val length: String,
    val elevationGain: String,
    val time: String,
    val profileImage: Int,
    val postImage: Int
)
