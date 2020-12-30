package com.debcomp.aql.sp42.feature.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.debcomp.aql.sp42.R
import com.debcomp.aql.sp42.feature.home.model.HomeViewModel
import com.debcomp.aql.sp42.feature.home.model.entity.Cadet
import com.debcomp.aql.sp42.feature.home.model.entity.User
import com.debcomp.aql.sp42.infra.Application42
import com.debcomp.aql.sp42.infra.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class HomeActivity : BaseActivity() {

    lateinit var viewModel: HomeViewModel

    private var allUsers: ArrayList<User> = arrayListOf()
    private var users: ArrayList<User> = arrayListOf()
    private var allCadets: ArrayList<Cadet> = arrayListOf()
    private var pages = 0
    private var cadets = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(
                this,
                HomeViewModel.HomeViewModelFactory(Application42.instance)
        ).get(HomeViewModel::class.java)


        setObservers()
        setActions()

        showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAllUsers()
        }
    }

    private fun setActions() {
        btn_search.setOnClickListener {
            loadCadets()
        }
    }

    private fun setObservers() {
        viewModel.cadetResponse.observe(this, Observer {
            allCadets.add(it)
            if (it != null) {
                Log.i("CADETE", "ACHEI O ${it.displayname}")
            }
            verifyCadets()
        })

        viewModel.allUsersResponse.observe(this, Observer {
            if (!it.isNullOrEmpty()) allUsers.addAll(it)
            verifyUsers()
        })
    }

    private fun verifyCadets() {
        if (allCadets.size < users.size) {
            loadCadets()
        } else {
            Toast.makeText(this, "ACABEI", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyUsers() {
        if (pages >= 6) {
            finished()
        }
    }

    private fun finished() {
        for (user in allUsers) {
            if (!user.login.matches(Regex(".*\\d.*")))
                users.add(user)
        }
        hideLoading()
        Toast.makeText(this, "total = ${users.size}", Toast.LENGTH_SHORT).show()
    }

    private fun loadCadets() {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getCadetById(users[cadets].login)
        }
        cadets++
    }
}