package br.com.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        if (view.id == R.id.btn_save) {
            hendlesave()
        }
    }

    private fun hendlesave() {
        val name = binding.editName.text.toString()
        if (name != "") {
            //linha responsável por carregar a Activity /  navegação entre activitys
            startActivity(Intent(this, MainActivity::class.java))
            //o finish mata a tela, e não a deixa ficar em memoria
            finish()
        } else {
            //linha responsável por exibir uma mensagem na tela
            Toast.makeText(
                this,
                R.string.validation_mandatory_name,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}