package com.tuxdev.protosender.ui.onboarding

import android.os.Bundle
import com.tuxdev.protosender.R
import com.tuxdev.protosender.base.BaseFragment
import com.tuxdev.protosender.databinding.FragmentOnboardingBinding

/**
 **********************************************
 * Created by ukie on 2/25/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */
class OnBoardingFragment : BaseFragment<FragmentOnboardingBinding>() {

    companion object {
        private const val PARAM_IMAGE = "image"
        private const val PARAM_TITLE = "title"
        private const val PARAM_MESSAGE = "message"

        fun newInstance(image: Int, title: String, message: String): OnBoardingFragment {
            val mainFragment = OnBoardingFragment()
            val args = Bundle()
            args.putInt(PARAM_IMAGE, image)
            args.putString(PARAM_TITLE, title)
            args.putString(PARAM_MESSAGE, message)
            mainFragment.arguments = args
            return mainFragment
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_onboarding

    override fun myCodeHere() {
        val args = arguments
        args?.apply {

            val image = getInt(PARAM_IMAGE)
            val title = getString(PARAM_TITLE)
            val message = getString(PARAM_MESSAGE)

            bind.ivBg.setImageResource(image)
            bind.tvTitle.text = title
            bind.tvMessage.text = message
        }

    }


}