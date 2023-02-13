package com.example.hero_datasource.network.service

import com.example.hero_datasource.network.HERO_STATS
import com.example.hero_datasource.network.dto.HeroDto
import com.example.hero_datasource.network.dto.toHero
import com.example.hero_domain.Hero
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

interface HeroService {

    suspend fun getHeroList(): List<Hero>
}

class HeroServiceImpl @Inject constructor(
    private val client: HttpClient
): HeroService {
    override suspend fun getHeroList(): List<Hero> =
        try {
            client.get<List<HeroDto>> {
                url(HERO_STATS)
            }.map { it.toHero() }
        } catch (e: java.lang.Exception) {
            emptyList<Hero>()
        }
}