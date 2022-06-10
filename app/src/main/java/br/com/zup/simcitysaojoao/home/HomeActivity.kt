package br.com.zup.simcitysaojoao.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.apresentacao.ApresentacaoFragment
import br.com.zup.simcitysaojoao.databinding.ActivityMainBinding
import br.com.zup.simcitysaojoao.produtos.CadastroDeProdutosFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "SimCity São João"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}