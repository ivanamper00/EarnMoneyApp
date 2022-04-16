package com.vietkiem.kimtinviinthoicabn.earn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpType
import com.dakulangsakalam.customwebview.presentation.utils.writeLogs
import com.vietkiem.kimtinviinthoicabn.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SplashActivity : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            splashAction(JumpType.JUMP_TESTING){ _,url ->
                writeLogs(url)
                startActivity(MainActivity.createIntent(this))
                finish()
            }
        }, 1500)
    }
}