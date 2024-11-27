package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.Game
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource

class Ex2DataRepository(
    private val gameDbLocalDataSource: GameDbLocalDataSource,
    private val mockEx2RemoteDataSource: MockEx2RemoteDataSource
) : Ex2Repository {
    override fun getGames(): List<Game> {
        val games = gameDbLocalDataSource.getGames()
        if (games.isEmpty()) {
            val remote = mockEx2RemoteDataSource.getGames()
            gameDbLocalDataSource.setGames(remote)
            return remote
        }
        return games
    }
}