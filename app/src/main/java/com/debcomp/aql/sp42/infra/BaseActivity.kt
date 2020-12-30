package com.debcomp.aql.sp42.infra

import androidx.appcompat.app.AppCompatActivity


/*
 * Davi Áquila
 * aquiladvx
 *
 * 16/12/2020
 *
 */

var isLoading = false
lateinit var loader: Loader

open class BaseActivity: AppCompatActivity() {

    fun showLoading() {
        if(!isLoading) {
            loader = Loader()
            loader.show(supportFragmentManager, "loading")
            isLoading = true
        }
    }

    fun hideLoading() {
        if (isLoading) {
            loader.dismiss()
            isLoading = false
        }
    }

}