package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.core.data.local.DataBaseProvider
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        val room = Ex2DataRepository(
            GameDbLocalDataSource(DataBaseProvider.provideDataBase(this).gameDao()),
            MockEx2RemoteDataSource()
        )
        GlobalScope.launch {
            //llamar a Room
            room.getGames()
        }

    }
}