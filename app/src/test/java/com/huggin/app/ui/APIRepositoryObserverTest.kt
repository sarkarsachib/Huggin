package com.huggin.app.ui

import com.huggin.app.LoadResponse
import com.huggin.app.MainAPI
import com.huggin.app.MainActivity.Companion.afterPluginsLoadedEvent
import com.huggin.app.TvType
import com.huggin.app.mvvm.Resource
import com.huggin.app.newMovieLoadResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class APIRepositoryObserverTest {
    @Test fun creatingRepositoriesDoesNotAccumulatePluginObservers() {
        val api = object : MainAPI() {}
        APIRepository(api)
        val before = afterPluginsLoadedEvent.size
        repeat(200) { APIRepository(api) }
        assertEquals(before, afterPluginsLoadedEvent.size)
    }

    @Test fun onlyForcedPluginReloadInvalidatesSharedResponseCache() = runBlocking {
        var loads = 0
        val api = object : MainAPI() {
            override var name = "ObserverReloadRegression"
            override var mainUrl = "https://example.com"
            override suspend fun load(url: String): LoadResponse {
                loads++
                return newMovieLoadResponse("Example", url, TvType.Movie, "video")
            }
        }
        val repo = APIRepository(api)
        afterPluginsLoadedEvent.invoke(true)
        assertTrue(repo.load("https://example.com/movie") is Resource.Success)
        assertTrue(APIRepository(api).load("https://example.com/movie") is Resource.Success)
        assertEquals(1, loads)
        afterPluginsLoadedEvent.invoke(false)
        assertTrue(repo.load("https://example.com/movie") is Resource.Success)
        assertEquals(1, loads)
        afterPluginsLoadedEvent.invoke(true)
        assertTrue(repo.load("https://example.com/movie") is Resource.Success)
        assertEquals(2, loads)
    }
}
