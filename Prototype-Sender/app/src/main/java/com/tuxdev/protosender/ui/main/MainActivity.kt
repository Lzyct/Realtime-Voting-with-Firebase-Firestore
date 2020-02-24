package com.tuxdev.protosender.ui.main

import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.tuxdev.protosender.R
import com.tuxdev.protosender.base.BaseActivity
import com.tuxdev.protosender.databinding.ActivityMainBinding

/**
 **********************************************
 * Created by ukie on 2/25/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {
    //    private val prefManager by inject<PrefManager>()
    private var vote1Count = 0
    private var vote2Count = 0

    override fun getToolbarResource(): Int = 1
    override fun getLayoutResource(): Int = R.layout.activity_main


    override fun myCodeHere() {
//        log(prefManager.getBoolean(prefManager.PREF_ONBOARD).toString())
        /*if (!prefManager.getBoolean(prefManager.PREF_ONBOARD)) {
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }*/

        //init db
        val db = FirebaseFirestore.getInstance()

        bind.btnVote1.setOnClickListener {
            vote1Count++
            isEnableButton(false)
            db.collection("vote").document("vote1")
                    .set(linkedMapOf("voteName" to "User 1", "voteCount" to vote1Count))
                    .addOnSuccessListener {
                        Toast.makeText(this, "update count User 1 to $vote1Count", Toast.LENGTH_SHORT).show()
                        bind.tvCountUser1.text = vote1Count.toString()
                        isEnableButton(true)
                    }.addOnFailureListener {
                        it.printStackTrace()
                        isEnableButton(true)
                    }
        }

        bind.btnVote2.setOnClickListener {
            vote2Count++
            isEnableButton(false)
            db.collection("vote").document("vote2")
                    .set(linkedMapOf("voteName" to "User 2", "voteCount" to vote2Count))
                    .addOnSuccessListener {
                        Toast.makeText(this, "update count User 2 to $vote2Count", Toast.LENGTH_SHORT).show()
                        bind.tvCountUser2.text = vote2Count.toString()
                        isEnableButton(true)
                    }.addOnFailureListener {
                        it.printStackTrace()
                        isEnableButton(true)
                    }
        }

    }

    data class VoteData(val name: String, val count: Int)

    private fun isEnableButton(isEnable: Boolean) {

        bind.btnVote1.isEnabled = isEnable
        bind.btnVote2.isEnabled = isEnable

        bind.pbLoading.visibility = if(isEnable) View.GONE else View.VISIBLE


    }
}