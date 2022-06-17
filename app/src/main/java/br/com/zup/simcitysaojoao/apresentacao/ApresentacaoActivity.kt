package br.com.zup.simcitysaojoao.apresentacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityApresentacaoBinding

class ApresentacaoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApresentacaoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApresentacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}