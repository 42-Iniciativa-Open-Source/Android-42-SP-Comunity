package com.debcomp.aql.sp42.feature.home.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.debcomp.aql.sp42.feature.home.data.service.HomeService
import com.debcomp.aql.sp42.feature.home.model.entity.Cadet
import com.debcomp.aql.sp42.feature.home.model.entity.User
import com.debcomp.aql.sp42.infra.Constants
import com.debcomp.aql.sp42.infra.util.MyFileUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*
 * Davi Áquila
 * aquiladvx
 *
 * 19/12/2020
 *
 */

class HomeRepository(private val app: Application) {

    val cadetResponse = MutableLiveData<Cadet>()
    val allUsersResponse = MutableLiveData<List<User>>()

    lateinit var apiKey: String

    init {
        apiKey = MyFileUtils.readFile(app)
    }

    @WorkerThread
    suspend fun getCadetById(userId: String) {
        if (networkAvailable(app)) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.WEB_SERVICE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit
                    .create(HomeService::class.java)
            val serviceData = service
                    .getCadetById(apiKey, userId)

            serviceData.enqueue(object : Callback<Cadet> {
                override fun onResponse(call: Call<Cadet>, response: Response<Cadet>) {
                    cadetResponse.postValue(response.body())
                }

                override fun onFailure(call: Call<Cadet>, t: Throwable) {
                    Log.e("Error Call", t.message!!)
                }
            })
        }
    }

    @WorkerThread
    suspend fun getAllUsers(page: Int) {
        if (networkAvailable(app)) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.WEB_SERVICE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit
                    .create(HomeService::class.java)
            val serviceData = service
                    .getAllCadets(apiKey, page)

            serviceData.enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    val header = response.headers()
                    allUsersResponse.value = response.body()
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.e("Error Call", t.message!!)
                }
            })
        }
    }



    private fun networkAvailable(context: Context): Boolean {
        val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}