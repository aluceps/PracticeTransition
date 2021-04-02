package me.aluceps.practicetransition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import me.aluceps.practicetransition.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivitySubBinding>(this, R.layout.activity_sub)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.root
    }

    companion object {
        private fun createIntent(context: Context) =
            Intent(context, SubActivity::class.java)
                .apply {
                }

        fun start(context: Context) {
            createIntent(context).let {
                context.startActivity(it)
            }
        }
    }
}