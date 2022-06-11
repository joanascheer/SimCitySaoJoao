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
import br.com.zup.simcitysaojoao.model.Produto

class CadastroDeProdutosFragment : Fragment() {
    private lateinit var binding: FragmentCadastroDeProdutosBinding

    private lateinit var nome: String
    private lateinit var quantidade: String
    private lateinit var valor: String
    private lateinit var receita: String

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
            enviarProduto()
        }
        binding.btnVerProdutos.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_cadastroDeProdutosFragment_to_listaDeProdutosFragment)
        }
        binding.btnValorTotal.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_cadastroDeProdutosFragment_to_valorTotalFragment)
        }
    }

    private fun enviarProduto() {
        mensagemSucesso()
        val produto = recuperarInformacoes()
        if (produto != null) {
            val bundle = bundleOf(PRODUCT_KEY to produto)
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_cadastroDeProdutosFragment_to_listaDeProdutosFragment, bundle)
        }
    }

    private fun mensagemSucesso() {
        Toast.makeText(
            context,
            MSG_PRODUTO_ADICIONADO,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun recuperarInformacoes(): Produto? {
        nome = binding.etNomeProduto.text.toString()
        quantidade = binding.etQuantidadeProduto.text.toString()
        valor = binding.etValorProduto.text.toString()
        receita = binding.etReceitaProduto.text.toString()

        if (nome.isNotEmpty() && quantidade.isNotEmpty() && valor.isNotEmpty() && receita.isNotEmpty()) {
            limparCampoInformacoes()
            return Produto(
                nome,
                quantidade.toInt(),
                valor.toDouble(),
                receita
            )
        } else {
            exibirMensagemErro()
        }
        return null
    }

    private fun limparCampoInformacoes() {
        binding.etNomeProduto.text.clear()
        binding.etQuantidadeProduto.text.clear()
        binding.etValorProduto.text.clear()
        binding.etReceitaProduto.text.clear()
    }

    private fun exibirMensagemErro() {
        binding.etNomeProduto.error = MSG_ERRO_NOME_PRODUTO
        binding.etQuantidadeProduto.error = MSG_ERRO_QUANTIDADE_PRODUTO
        binding.etValorProduto.error = MSG_ERRO_VALOR_PRODUTO
        binding.etReceitaProduto.error = MSG_ERRO_RECEITA_PRODUTO
    }
}