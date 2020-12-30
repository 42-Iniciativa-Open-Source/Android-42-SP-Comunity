package com.debcomp.aql.sp42.feature

import android.content.Intent
import android.os.Bundle
import com.debcomp.aql.sp42.R
import com.debcomp.aql.sp42.feature.home.view.HomeActivity
import com.debcomp.aql.sp42.infra.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        activityScope.launch {
            delay(2500)

            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}