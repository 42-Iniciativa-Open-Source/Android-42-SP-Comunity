package com.debcomp.aql.sp42.infra.util

import android.content.Context
import com.debcomp.aql.sp42.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/*
 *
 * Davi Aquila
 * aquiladvx
 *
 * Project: 42SP
 * 07/01/2021  
 * 
 */

class MyFileUtils {

    companion object {
        fun readFile(context: Context): String {
            var string: String? = ""
            val stringBuilder = StringBuilder()
            val `is`: InputStream = context.resources.openRawResource(R.raw.key)
            val reader = BufferedReader(InputStreamReader(`is`))
            while (true) {
                try {
                    if (reader.readLine().also { string = it } == null) break
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                stringBuilder.append(string)
            }
            `is`.close()
            return stringBuilder.toString()

        }
    }
}