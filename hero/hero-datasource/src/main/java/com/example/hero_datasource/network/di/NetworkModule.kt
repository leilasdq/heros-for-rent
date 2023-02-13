package com.example.hero_datasource.network.di

import com.example.hero_datasource.network.service.HeroService
import com.example.hero_datasource.network.service.HeroServiceImpl
import dagger.hilt.InstallIn
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.http.*


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHttpClient(): HttpClient =
        HttpClient {
            Logging {
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
                this.acceptContentTypes = listOf(ContentType.Application.Json)
            }
        }

    @Provides
    fun provideHeroService(client: HttpClient): HeroService =
        HeroServiceImpl(client)
}