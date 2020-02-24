package com.tuxdev.protoviewer.utils

import android.util.Log

/**
 **********************************************
 * Created by ukietux on 2020-02-11 with ♥
 * (>’_’)> email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux <(’_’<)
 **********************************************
 * © 2020 | All Right Reserved
 */

fun log(message: String, tag: String = "⌜TuxDev⌟") {
    Log.d(tag, "┌================================================================================")
    Log.d(tag, "│$message")
    Log.d(tag, "└================================================================================")
}