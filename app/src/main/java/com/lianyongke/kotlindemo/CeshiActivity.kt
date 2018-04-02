package com.lianyongke.kotlindemo

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by lianyongke on 2018/3/24.
 */
class CeshiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLongToast("hhh")
    }

    fun Activity.showLongToast(str : String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

}