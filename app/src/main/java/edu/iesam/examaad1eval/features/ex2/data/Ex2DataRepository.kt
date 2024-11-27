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
        user.forEach {
            list.add(it)
        }
        val games = mockEx2RemoteDataSource.getGames()
        games.forEach {
            if (list.size <= 7) {
                list.add(it)
            }
    }
        gameDbLocalDataSource.deleteGames()
        val list2 = list.subList(3, 8)
        gameDbLocalDataSource.setGames(list2)
        return list

}
}