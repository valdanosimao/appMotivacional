package br.com.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener(this)

        supportActionBar?.hide()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_save){

        }
    }
}