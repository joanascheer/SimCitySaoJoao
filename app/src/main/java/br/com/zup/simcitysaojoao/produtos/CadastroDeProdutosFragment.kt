package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.*
import br.com.zup.simcitysaojoao.databinding.FragmentCadastroDeProdutosBinding
import br.com.zup.simcitysaojoao.home.HomeActivity
import br.com.zup.simcitysaojoao.model.Produto

class CadastroDeProdutosFragment : Fragment() {
    private lateinit var binding: FragmentCadastroDeProdutosBinding

    private lateinit var nome: String
    private lateinit var quantidade: String
    private lateinit var valor: String
    private lateinit var receita: String

    private var listaProdutos = arrayListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroDeProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as HomeActivity).supportActionBar?.title = getString(R.string.produtos_label_txt)

        receberListaDeValorTotal()

        binding.btnCadastrarProduto.setOnClickListener {
            clickBtnAdicionar()
        }

        binding.btnVerProdutos.setOnClickListener {
            if (listaProdutos.isEmpty()) {
                Toast.makeText(context,getString(R.string.lista_vazia), 2000).show()
            } else {
                clickBtnVerLista()
            }

        }
        binding.btnValorTotal.setOnClickListener {
            clickBtnValorTotal()
        }
    }


    private fun receberListaDeValorTotal() {
        val listaRecebida = arguments?.getParcelableArrayList<Produto>(LIST_KEY_VALOR_TOTAL)
        listaRecebida?.let {
            listaProdutos = it
        }
    }

    private fun adidionarProdutoLista() {
        mensagemSucesso()
        recuperarInformacoes()
        if (verificarCampos()) {
            val produto = Produto(
                nome,
                quantidade.toInt(),
                valor.toDouble(),
                receita
            )
            listaProdutos.add(produto)
            limparCampoInformacoes()
        }
    }

    private fun clickBtnAdicionar() {
        adidionarProdutoLista()
    }

    private fun clickBtnVerLista() {
        val bundle = bundleOf(LIST_KEY to listaProdutos)

        NavHostFragment.findNavController(this)
            .navigate(R.id.action_cadastroDeProdutosFragment_to_listaDeProdutosFragment, bundle)
    }

    private fun clickBtnValorTotal() {
        val bundle = bundleOf(LIST_KEY to listaProdutos)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_cadastroDeProdutosFragment_to_valorTotalFragment, bundle)

    }

    private fun mensagemSucesso() {
        Toast.makeText(
            context,
            MSG_PRODUTO_ADICIONADO,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun recuperarInformacoes() {
        nome = binding.etNomeProduto.text.toString()
        quantidade = binding.etQuantidadeProduto.text.toString()
        valor = binding.etValorProduto.text.toString()
        receita = binding.etReceitaProduto.text.toString()
    }

    private fun verificarCampos(): Boolean {
        when {
            nome.isEmpty() -> {
                binding.etNomeProduto.error = MSG_ERRO_NOME_PRODUTO
                return false
            }
            quantidade.isEmpty() -> {
                binding.etQuantidadeProduto.error = MSG_ERRO_QUANTIDADE_PRODUTO
                return false
            }
            valor.isEmpty() -> {
                binding.etValorProduto.error = MSG_ERRO_VALOR_PRODUTO
                return false
            }
            receita.isEmpty() -> {
                binding.etReceitaProduto.error = MSG_ERRO_RECEITA_PRODUTO
                return false
            }
        }
        return true
    }

    private fun limparCampoInformacoes() {
        binding.etNomeProduto.text.clear()
        binding.etQuantidadeProduto.text.clear()
        binding.etValorProduto.text.clear()
        binding.etReceitaProduto.text.clear()
    }

}