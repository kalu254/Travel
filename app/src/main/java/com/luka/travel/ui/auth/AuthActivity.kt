package com.luka.travel.ui.auth

import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
import androidx.appcompat.app.AppCompatActivity
import com.luka.travel.R

class AuthActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.let {
            it.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            it.statusBarColor = getColor(R.color.auth_status_color)
        }

        setContentView(R.layout.activity_auth)



    }
}
