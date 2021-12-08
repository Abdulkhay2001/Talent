package com.Abdul.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.Abdul.data.Repository
import com.Abdul.data.User
import com.Abdul.database.UserDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val repository = Repository(application.applicationContext)
    val liveData: MutableLiveData<List<UserDB>> = MutableLiveData()
    val userLiveData = MutableLiveData<UserDB>()

    fun getUserById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            userLiveData.postValue(repository.getUser(id))
        }
    }

    fun getFromRoom() {
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(repository.getUsers())
        }
    }

    fun getFromServer() {
        viewModelScope.launch {
            repository.getFromServer().enqueue(object : retrofit2.Callback<List<UserDB>> {
                override fun onResponse(
                    call: Call<List<UserDB>>,
                    response: Response<List<UserDB>>
                ) {
                    Log.d("TEST_TAG", "do is successfuk")
                    if (!response.isSuccessful) return
                    Log.d("TEST_TAG", "do let!")
                    response.body()?.let {
                        Log.d("TEST_TAG", " vsyo ok!!!!")
                        viewModelScope.launch(Dispatchers.IO) {
                            repository.deleteAllFromRoom()
                            for (item in it)
                                repository.addUser(item)
                            getFromRoom()
                        }
                    }
                }

                override fun onFailure(call: Call<List<UserDB>>, t: Throwable) {
                    Log.d("TEST_TAG", "net interneta!!!!${t}")
                    getFromRoom()
                }

            })
        }
    }
}
