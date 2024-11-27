package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.User

class UserXmlLocalDataSource(context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.shared), Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveUsers(users: List<User>) {
        val usersJson = gson.toJson(users)
        sharedPref.edit().putString("users", usersJson).apply()
    }

    fun getUsers(): List<User>? {
        val usersJson = sharedPref.getString("users", null)
        return if (usersJson != null) {
            gson.fromJson(usersJson, Array<User>::class.java).toList()
        } else {
            null
        }
    }

}