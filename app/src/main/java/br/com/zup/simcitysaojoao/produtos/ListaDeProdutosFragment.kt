package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.LIST_KEY
import br.com.zup.simcitysaojoao.PRODUCT_KEY
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentListaDeProdutosBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.produtos.adapter.ProdutoAdapter

class ListaDeProdutosFragment : Fragment() {
    private lateinit var binding: FragmentListaDeProdutosBinding

    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), ::irParaDetalhes)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaDeProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receberListaEnviada()
    }

    private fun exibirRecyclerView() {
        binding.rvListaProdutos.adapter = produtoAdapter
        binding.rvListaProdutos.layoutManager = LinearLayoutManager(context)
    }

    private fun irParaDetalhes(produto: Produto) {
        val bundle = bundleOf(PRODUCT_KEY to produto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_listaDeProdutosFragment_to_detalhesDeProdutosFragment, bundle)
    }

    private fun receberListaEnviada() {
        val listaDeProdutos = arguments?.getParcelableArrayList<Produto>(LIST_KEY)
        if (listaDeProdutos != null) {
            atualizarListaProdutos(listaDeProdutos)
        }
    }

    private fun atualizarListaProdutos(listaDeProdutos: ArrayList<Produto>) {
        produtoAdapter.atualizarListaProdutos(listaDeProdutos)
        exibirRecyclerView()
    }



}