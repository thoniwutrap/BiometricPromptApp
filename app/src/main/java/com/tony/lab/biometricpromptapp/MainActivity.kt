package com.tony.lab.biometricpromptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val executor = Executors.newSingleThreadExecutor()
        val activity: FragmentActivity = this // reference to activity
        val biometricPrompt = BiometricPrompt(activity, executor, object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    Log.e("authen","faile")
                } else {
                    Log.e("authen","faile")
                }
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Log.e("authen","pass")
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Log.e("authen","faile")
            }
        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Set the title to display.")
            .setSubtitle("Set the subtitle to display.")
            .setDescription("Set the description to display")
            .setNegativeButtonText("Negative Button")
            .build()

        btnAuthenByFingerprint.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }
    }
}
