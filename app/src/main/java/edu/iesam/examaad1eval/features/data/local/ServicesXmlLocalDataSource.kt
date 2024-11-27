package edu.iesam.examaad1eval.features.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.Services

class ServicesXmlLocalDataSource(context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.shared), Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveServices(services: List<Services>) {
        val servicesJson = gson.toJson(services)
        sharedPref.edit().putString("services", servicesJson).apply()
    }

    fun getServices(): List<Services> {
        val servicesJson = sharedPref.getString("services", null)
        return if (servicesJson != null) {
            gson.fromJson(servicesJson, Array<Services>::class.java).toList()
        } else {
            emptyList()
        }
    }
}