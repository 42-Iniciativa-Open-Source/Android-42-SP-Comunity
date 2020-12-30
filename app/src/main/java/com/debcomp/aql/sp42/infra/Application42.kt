package com.debcomp.aql.sp42.infra

import android.app.Application


/*
 * Davi Áquila
 * aquiladvx
 *
 * 19/12/2020
 *
 */

class Application42: Application(){


    companion object {
        lateinit var instance: Application42
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}