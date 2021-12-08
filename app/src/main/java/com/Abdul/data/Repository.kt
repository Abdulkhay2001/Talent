package com.Abdul.data

import android.content.Context
import com.Abdul.database.UserDB
import com.Abdul.database.UserDatabase
import retrofit2.Call

class Repository(val context: Context) {
    val dao = UserDatabase.getDatabase(context).userDao()
    val retrofit = RetrofitClient.getRandomDataApi()

    suspend fun getUsers(): List<UserDB>{
        return dao.getAll()
    }

    suspend fun deleteAllFromRoom() {
        return dao.deleteUser()
    }

    suspend fun getUser(id : Int): UserDB {
        return dao.getUserById(id)
    }

    suspend fun getFromServer() : Call<List<UserDB>> {
        return retrofit.getNation()
    }

    suspend fun addUser(user: UserDB) {
        dao.addUser(user)
    }
}
