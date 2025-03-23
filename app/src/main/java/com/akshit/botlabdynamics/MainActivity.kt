package com.akshit.botlabdynamics

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akshit.botlabdynamics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        val isOpenCVInitialized = initOpenCV()

        // Update UI based on initialization status
        if (isOpenCVInitialized) {
            binding.opencvStatusText.text = "OpenCV initialized successfully!"
            binding.opencvStatusText.setTextColor(Color.GREEN)
        } else {
            binding.opencvStatusText.text = "OpenCV initialization failed!"
            binding.opencvStatusText.setTextColor(Color.RED)
        }
    }

    /**
     * A native method that is implemented by the 'botlabdynamics' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun initOpenCV(): Boolean

    companion object {
        // Used to load the 'botlabdynamics' library on application startup.
        init {
            System.loadLibrary("botlabdynamics")
        }
    }
}