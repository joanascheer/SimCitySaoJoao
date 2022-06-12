package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.LIST_KEY
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentValorTotalBinding
import br.com.zup.simcitysaojoao.model.Produto


class ValorTotalFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentValorTotalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //lista recebida de cadastro
        val listaProdutos = arguments?.getParcelableArrayList<Produto>(LIST_KEY)
        calcularValorTotal(listaProdutos)

        binding.btnCadastrarNovoProduto.setOnClickListener {
            navegarParaCadastroProdutos(listaProdutos)
        }

        binding.btnVerProdutos.setOnClickListener {
            navegarParaVerProdutos(listaProdutos)
        }
    }

    private fun navegarParaCadastroProdutos(listaProdutos: ArrayList<Produto>?) {
        val bundle = bundleOf(LIST_KEY to listaProdutos)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_valorTotalFragment_to_cadastroDeProdutosFragment)
    }

    private fun navegarParaVerProdutos(listaProdutos: ArrayList<Produto>?) {
        val bundle = bundleOf(LIST_KEY to listaProdutos)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_valorTotalFragment_to_listaDeProdutosFragment, bundle)
    }

    private fun calcularValorTotal(listaProdutos: ArrayList<Produto>?) {
        var valorTotal = 0.0
        listaProdutos?.forEach { produto ->
            valorTotal += produto.getValorUnitario() * produto.getQuantidade()
        }
        binding.tvValorTotal.text =
            "total R$ ${formatarValorTotal(valorTotal)}"
    }

    private fun formatarValorTotal(valorTotal: Double) = "%.2f".format(valorTotal)

}
