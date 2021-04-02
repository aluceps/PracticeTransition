package me.aluceps.practicetransition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import me.aluceps.practicetransition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.showActivityAnim1.setOnClickListener {
            SubActivity.start(this, SubActivity.Transition.Default)
        }
        binding.showActivityAnim2.setOnClickListener {
            SubActivity.start(this, SubActivity.Transition.Fade)
        }
        binding.showActivityAnim3.setOnClickListener {
            SubActivity.start(this, SubActivity.Transition.Slide)
        }
    }
}