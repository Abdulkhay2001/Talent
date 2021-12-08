package com.Abdul.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.Abdul.database.CountryDB
import com.Abdul.database.UserDB

@Dao
interface UserDao {
    @Insert
    fun addUser(userDao: UserDB)

    @Query("SELECT * from User_table")
    fun getAll(): List<UserDB>

    @Query("SELECT * FROM User_table WHERE User_table.userId = :id")
    fun getUserById(id:Int) : UserDB

    @Insert
    fun addCountry(countryDB: CountryDB)

    @Query("DELETE FROM User_table")
    fun deleteUser()

}