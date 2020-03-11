package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.example.livedata.databinding.ActivityMainBinding
import java.util.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this)
                .get(MainViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
                this, R.layout.activity_main
        ).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.viewmodel = mainViewModel
        }

        mainViewModel.editTextContent.observe(this, androidx.lifecycle.Observer { Toast.makeText(this,it,Toast.LENGTH_SHORT).show() })
    }
}


