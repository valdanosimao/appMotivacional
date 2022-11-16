package br.com.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.motivation.R
import br.com.motivation.data.Mock
import br.com.motivation.databinding.ActivityMainBinding
import br.com.motivation.infra.MotivationConstants
import br.com.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // remove a supportActionBar
        supportActionBar?.hide()

        headleUserName()
        handleFilter(R.id.image_all)
        handleNextPhrase()

        /**
         * Atribui eventos aos elementos
         */
        binding.btnNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageEmotions.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    /**
     * Trata eventos de click
     */
    override fun onClick(view: View) {

        if (view.id == R.id.btn_new_phrase) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.image_all, R.id.image_emotions, R.id.image_sunny)) {
            handleFilter(view.id)
        }
    }


    /**
     * Atualiza frase de motivação
     */
    private fun handleNextPhrase(){
        val  phrase = Mock().getPhrase(categoryId)
        binding.textPhrase.text = phrase
    }

    /**
     * Trata o filtro aplicado para as frases
     */
    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageEmotions.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_emotions -> {
                binding.imageEmotions.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.EMOTIONS
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    /**
     * Busca o nome do usuário
     */
    private fun headleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá $name!"
    }
}