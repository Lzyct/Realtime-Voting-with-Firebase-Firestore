package com.tuxdev.protoviewer.ui.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import com.tuxdev.protoviewer.R
import com.tuxdev.protoviewer.base.BaseActivity
import com.tuxdev.protoviewer.databinding.ActivitySplashBinding
import com.tuxdev.protoviewer.ui.main.MainActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    private val compositeDisposable = CompositeDisposable()
    override fun getToolbarResource(): Int = 0
    override fun getLayoutResource(): Int = R.layout.activity_splash

    @SuppressLint("MissingPermission")
    override fun myCodeHere() {
        bind.lifecycleOwner = this
        bind.appVersion.text = getString(R.string.app_name)

        compositeDisposable.add(Observable.timer(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.single())
                .subscribe {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                })
    }

}
