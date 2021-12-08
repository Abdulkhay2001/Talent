package com.Abdul.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.Abdul.R
import com.Abdul.database.CountryDB
import com.Abdul.database.UserDB
import com.Abdul.database.UserDatabase
import com.Abdul.databinding.ActivityShortOpisanieBinding
import com.Abdul.ui.adapters.UserListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShortDescriptionActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView;

    lateinit var binding: ActivityShortOpisanieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShortOpisanieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}


/*
        val userDataBase = UserDatabase
        val dao = userDataBase.getDatabase(this).userDao()

        val country = CountryDB(1, "Hujand")
         val userDB = UserDB(1, "Stivin Jack", 1, "Android", "Android developer", R.drawable.images1)

         CoroutineScope(Dispatchers.IO).launch {
             dao.addCountry(country)
             dao.addUser(userDB)
         }*/
