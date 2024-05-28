package com.example.loginapi

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/****
 * Project: Stores API REST
 * From: com.cursosant.storesapirest.common.database
 * Created by Alain Nicolás Tello on 18/12/23 at 12:50
 * All rights reserved 2024.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 ***/
class ReqResAPI constructor(context: Context) {
    companion object{
        @Volatile
        private var INSTANCE: ReqResAPI? = null

        fun getInstance(context: Context) = INSTANCE ?: synchronized(this){
            INSTANCE ?: ReqResAPI(context).also { INSTANCE = it }
        }
    }

    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>){
        requestQueue.add(req)
    }
}