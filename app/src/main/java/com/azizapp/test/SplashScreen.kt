package com.azizapp.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.splashscreen.*

class SplashScreen : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        drainit.alpha = 0f
        drainit.animate().setDuration(3000).alpha(1f).withEndAction {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}