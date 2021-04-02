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

    private val type by lazy {
        intent.getSerializableExtra(ANIM_TYPE) as Transition
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.root
    }

    override fun finish() {
        super.finish()
        setTransition(this, type)
    }


    companion object {
        const val ANIM_TYPE = "anim_type"

        private fun createIntent(context: Context) =
            Intent(context, SubActivity::class.java)
                .apply {
                }

        private fun setTransition(activity: AppCompatActivity, type: Transition) {
            when (type) {
                Transition.Default -> Unit
                Transition.Fade -> activity.overridePendingTransition(
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
                )
                Transition.Slide -> activity.overridePendingTransition(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
            }
        }

        fun start(context: Context, type: Transition) {
            createIntent(context).let {
                it.putExtra(ANIM_TYPE, type)
                context.startActivity(it)
                setTransition(context as AppCompatActivity, type)
            }
        }
    }

    enum class Transition {
        Default,
        Fade,
        Slide,
    }
}