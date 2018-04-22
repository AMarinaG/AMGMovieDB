package com.amarinag.amgmoviedb.ui.detail

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.amarinag.amgmoviedb.R
import com.amarinag.amgmoviedb.databinding.ActivityDetailBinding
import com.amarinag.amgmoviedb.ui.base.BaseActivity

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }

        @JvmStatic
        fun start(context: Context, activityOptions: ActivityOptions) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent, activityOptions.toBundle())
        }
    }
}
