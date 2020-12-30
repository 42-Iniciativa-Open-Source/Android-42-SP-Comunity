package com.debcomp.aql.sp42.feature.home.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.debcomp.aql.sp42.feature.home.data.HomeRepository


/*
 * Davi Áquila
 * aquiladvx
 *
 * 19/12/2020
 *
 */

class HomeViewModel(app: Application): AndroidViewModel(app) {


    private val homeRepo = HomeRepository(app)

    val cadetResponse = homeRepo.cadetResponse
    val allUsersResponse = homeRepo.allUsersResponse

    suspend fun getCadetById(userId: String) = homeRepo.getCadetById(userId)


    suspend fun getAllUsers() {
        for (x in 1..6) {
            homeRepo.getAllUsers(x)
        }
    }


    class HomeViewModelFactory constructor(private val application: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                HomeViewModel(this.application) as T
            } else {
                throw IllegalArgumentException("ViewModel not found")
            }
        }
    }
}