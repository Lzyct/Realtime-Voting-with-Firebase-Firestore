package com.tuxdev.protosender

import android.app.Application
import com.tuxdev.protosender.di.baseApp
import com.tuxdev.protosender.utils.log
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
 * *********************************************
 * Created by ukie on 9/26/18 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2018 | All Right Reserved
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //Insert Koin
        startKoin {
            log("koin start")
            androidContext(this@App)
            modules(baseApp)
        }

    }


}
