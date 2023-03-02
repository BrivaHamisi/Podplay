package com.brivadigital.podplay.repository

import com.brivadigital.podplay.service.ItunesService

class ItunesRepo(private val itunesService: ItunesService) {
    suspend fun searchByTerm(term:String) = itunesService.searchPodcastByTerm(term)
}