package br.com.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconde a barra de navegação
        supportActionBar?.hide()

        //Eventos
        binding.btnNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
           if(view.id == R.id.btn_new_phrase){
               var s = ""
           }
    }
}