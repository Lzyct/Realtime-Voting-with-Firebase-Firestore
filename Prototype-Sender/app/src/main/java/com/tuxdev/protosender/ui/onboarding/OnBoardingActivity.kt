package com.tuxdev.protosender.ui.onboarding

import android.content.Intent
import android.view.MenuItem
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.tuxdev.protosender.R
import com.tuxdev.protosender.base.BaseActivity
import com.tuxdev.protosender.databinding.ActivityOnboardingBinding
import com.tuxdev.protosender.ui.main.MainActivity
import com.tuxdev.protosender.utils.PrefManager
import org.koin.android.ext.android.inject


/**
 **********************************************
 * Created by ukie on 2/25/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */
class OnBoardingActivity : BaseActivity<ActivityOnboardingBinding>() {
    private val prefManager by inject<PrefManager>()

    override fun getToolbarResource(): Int = 0

    override fun getLayoutResource(): Int = R.layout.activity_onboarding

    override fun myCodeHere() {
        //if onboarding page is 3

        val listImage = arrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val listTitle = arrayOf(
                getString(R.string.onboard_title1),
                getString(R.string.onboard_title2),
                getString(R.string.onboard_title3)
        )
        val listMessage = arrayOf(
                getString(R.string.onboard_message1),
                getString(R.string.onboard_message2),
                getString(R.string.onboard_message3)
        )

        val onBoardAdapter = OnBoardingAdapter(
                supportFragmentManager, this
                , listImage, listTitle, listMessage
        )
        onBoardAdapter.showIndicator(bind.llIndicator, bind.vpOnboarding)

        bind.vpOnboarding.adapter = onBoardAdapter
        bind.vpOnboarding.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                bind.cvStart.visibility =
                        if (position == onBoardAdapter.count - 1) View.VISIBLE else View.GONE
            }

        })
        bind.cvStart.setOnClickListener {
            prefManager.saveBoolean(prefManager.PREF_ONBOARD, true)
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                prefManager.saveBoolean(prefManager.PREF_ONBOARD, true)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        prefManager.saveBoolean(prefManager.PREF_ONBOARD, true)
    }
}