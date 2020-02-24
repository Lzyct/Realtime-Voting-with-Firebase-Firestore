package com.tuxdev.protosender.ui.onboarding

import android.content.Context
import android.view.Gravity
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.tuxdev.protosender.R

/**
 **********************************************
 * Created by ukie on 2/25/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */

class OnBoardingAdapter(
        fragmentManager: FragmentManager,
        private val context: Context,
        private val listImage: Array<Int>,
        private val listTitle: Array<String>,
        private val listMessage: Array<String>
) : FragmentStatePagerAdapter(fragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT),
        ViewPager.OnPageChangeListener {

    override fun getItem(position: Int): Fragment =
            OnBoardingFragment.newInstance(listImage[position], listTitle[position], listMessage[position])

    override fun getCount(): Int = listImage.size

    private var indexPage = 0

    private lateinit var linearLayout: LinearLayoutCompat
    private lateinit var viewPager: ViewPager

    fun showIndicator(linearLayout: LinearLayoutCompat, viewPager: ViewPager) {
        this.linearLayout = linearLayout
        this.viewPager = viewPager

        for (i in listImage.indices) {
            val view = View(context)
            view.layoutParams = setLayoutParams(20, 6)
            view.background = ContextCompat.getDrawable(context, R.drawable.ic_indicator)
            view.isSelected = i == 0
            linearLayout.gravity = Gravity.START or Gravity.CENTER_VERTICAL
            this.linearLayout.addView(view)

        }
        viewPager.addOnPageChangeListener(this)
        setSelectedIndicator()

    }

    private fun setSelectedIndicator() {
        for (i in listImage.indices) {
            val view = linearLayout.getChildAt(i)
            view.isSelected = i == indexPage


            if (i == indexPage) {
                view.layoutParams = setLayoutParams(18, 6)
            } else {
                view.layoutParams = setLayoutParams(10, 3)
            }
        }
    }

    private fun setLayoutParams(wh: Int, margin: Int): LinearLayoutCompat.LayoutParams {
        val res = context.resources
        val dimen: Int = res.displayMetrics.density.times(wh).toInt()
        val layoutParams = LinearLayoutCompat.LayoutParams(dimen, dimen)
        layoutParams.topMargin = res.displayMetrics.density.times(margin).toInt()
        layoutParams.leftMargin = res.displayMetrics.density.times(margin).toInt()
        layoutParams.rightMargin = res.displayMetrics.density.times(margin).toInt()
        layoutParams.bottomMargin = res.displayMetrics.density.times(margin).toInt()

        return layoutParams
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        indexPage = position
        setSelectedIndicator()
    }
}