package com.tuxdev.protoviewer.ui.main

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.FirebaseFirestore
import com.tuxdev.protoviewer.R
import com.tuxdev.protoviewer.base.BaseActivity
import com.tuxdev.protoviewer.databinding.ActivityMainBinding
import com.tuxdev.protoviewer.utils.log


/**
 **********************************************
 * Created by ukie on 2/25/19 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2019 | All Right Reserved
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getToolbarResource(): Int = 0
    override fun getLayoutResource(): Int = R.layout.activity_main

    @RequiresApi(Build.VERSION_CODES.N)
    override fun myCodeHere() {

        val db = FirebaseFirestore.getInstance()

        val vote1 = db.collection("vote").document("vote1")
        vote1.addSnapshotListener { snapshot, e ->
            if (e != null) {
                log("Listen failed.")
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                log("Current data: ${snapshot.data}")
                bind.pbUser1.setProgress(snapshot.data?.get("voteCount")?.toString()?.toInt()
                        ?: 0, true)
                bind.tvCount1.text = snapshot.data?.get("voteCount")?.toString()
            } else {
                log("Current data: null")
            }
        }

        val vote2 = db.collection("vote").document("vote2")
        vote2.addSnapshotListener { snapshot, e ->
            if (e != null) {
                log("Listen failed.")
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                log("Current data: ${snapshot.data}")
                bind.pbUser2.setProgress(snapshot.data?.get("voteCount")?.toString()?.toInt()
                        ?: 0, true)
                bind.tvCount2.text = snapshot.data?.get("voteCount")?.toString()
            } else {
                log("Current data: null")
            }
        }


    }


}