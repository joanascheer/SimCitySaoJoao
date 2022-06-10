package br.com.zup.simcitysaojoao.apresentacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentApresentacaoBinding

class ApresentacaoFragment : Fragment() {
    private lateinit var binding: FragmentApresentacaoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentApresentacaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnIrProdutos.setOnClickListener {
            irParaCadastroProdutos()
        }
    }

    private fun irParaCadastroProdutos() {
        NavHostFragment.findNavController(this).navigate(
            R.id.action_apresentacaoFragment_to_cadastroDeProdutosFragment
        )
    }

}