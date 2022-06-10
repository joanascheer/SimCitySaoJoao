package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.LIST_KEY
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentCadastroDeProdutosBinding
import br.com.zup.simcitysaojoao.model.Produto

class CadastroDeProdutosFragment : Fragment() {
    private lateinit var binding: FragmentCadastroDeProdutosBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroDeProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCadastrarProduto.setOnClickListener {
            adicionarProdutosLista()
        }
        binding.btnVerProdutos.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_cadastroDeProdutosFragment_to_listaDeProdutosFragment)
        }
        binding.btnValorTotal.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_cadastroDeProdutosFragment_to_valorTotalFragment)
        }

    }

    private fun enviarListaDeProdutos(listaDeProdutos: MutableList<Produto>) {
        val bundle = bundleOf(LIST_KEY to listaDeProdutos)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_cadastroDeProdutosFragment_to_listaDeProdutosFragment, bundle)
    }

    private fun recuperarInformacoes(): Produto? {
        val nomeProduto = binding.etNomeProduto.text.toString()
        val quantidadeProduto = binding.etQuantidadeProduto.toString()
        val valorUnitarioProduto = binding.etValorProduto.text.toString()
        val receitaProduto = binding.etReceitaProduto.text.toString()

        if (nomeProduto.isNotEmpty() && quantidadeProduto.isNotEmpty() && valorUnitarioProduto.isNotEmpty() && receitaProduto.isNotEmpty()) {
            limparCampoInformacoes()
            return Produto(nomeProduto, quantidadeProduto, valorUnitarioProduto, receitaProduto)
        } else {
            exibirMensagemErro()
        }
        return null
    }

    // mando objeto e crio a lista la no adapter ou mando lista e nao inicio com lista vazia

    private fun adicionarProdutosLista(): MutableList<Produto> {
        val listaProdutos = mutableListOf<Produto>()
        val produto = recuperarInformacoes()

        if (produto != null) {
            listaProdutos.add(produto)
            enviarListaDeProdutos(listaProdutos)
            Toast.makeText(
                context,
                "Produto adicionado com sucesso!",
                Toast.LENGTH_LONG
            ).show()
        } else {
            exibirMensagemErro()
        }
        return listaProdutos
    }

    private fun limparCampoInformacoes() {
        binding.etNomeProduto.text.clear()
        binding.etQuantidadeProduto.text.clear()
        binding.etValorProduto.text.clear()
        binding.etReceitaProduto.text.clear()
    }

    private fun exibirMensagemErro() {
        binding.etNomeProduto.error = "Por favor, insira um nome para seu produto"
        binding.etQuantidadeProduto.error = "Por favor, insira uma quantidade válida"
        binding.etValorProduto.error = "Por favor, insira um valor válido para o seu produto"
        binding.etReceitaProduto.error = "Insira uma receita para o seu produto"
    }
}