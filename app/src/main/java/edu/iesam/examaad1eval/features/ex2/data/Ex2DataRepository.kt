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
        val list = mutableListOf<Game>()
        val user = gameDbLocalDataSource.getGames()
        if (user.isEmpty()){
            list.addAll(mockEx2RemoteDataSource.getGames())
            gameDbLocalDataSource.setGames(list.take(5))
            return list
        }else{
            list.addAll(user)
            val games = mockEx2RemoteDataSource.getGames()
            val newGames = games.filter { game -> list.none { it.id == game.id } }
            list.addAll(newGames)
            return list
        }
    }
}