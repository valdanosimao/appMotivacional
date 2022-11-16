package br.com.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.motivation.infra.MotivationConstants
import br.com.motivation.R
import br.com.motivation.infra.SecurityPreferences
import br.com.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener(this)

        supportActionBar?.hide()

        verifyUserName()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_save) {
            hendlesave()
        }
    }

    private fun verifyUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if(name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun hendlesave() {
        val name = binding.editName.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

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