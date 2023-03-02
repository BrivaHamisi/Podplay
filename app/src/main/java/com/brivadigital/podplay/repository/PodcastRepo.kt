package com.brivadigital.podplay.repository

import com.brivadigital.podplay.model.Podcast

class PodcastRepo {
    fun getPodcast(feedUrl: String):Podcast?{
        return Podcast(feedUrl, "No Name", "No Description", "No image")
    }
}