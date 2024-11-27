package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.Item

class ItemXmlLocalDataSource(context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.shared), Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveItems(items: List<Item>) {
        val itemsJson = gson.toJson(items)
        sharedPref.edit().putString("items", itemsJson).apply()
    }

    fun getItems(): List<Item>? {
        val itemsJson = sharedPref.getString("items", null)
        return if (itemsJson != null) {
            gson.fromJson(itemsJson, Array<Item>::class.java).toList()
        } else {
            null
        }
    }

}