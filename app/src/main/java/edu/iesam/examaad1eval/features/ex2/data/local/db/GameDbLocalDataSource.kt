package edu.iesam.examaad1eval.features.ex2.data.local.db

import edu.iesam.examaad1eval.features.ex2.Game

class GameDbLocalDataSource(
    private val dao: GameDao
) {
    fun getGames(): List<Game> {
        return dao.getAll().map {
            it.toModel()
        }
    }

    fun setGames(games: List<Game>) {
        dao.insertAll(*games.map {
            it.toEntity()
        }.toTypedArray())
    }


    fun deleteGames() {
        dao.deleteAll()
    }
}