package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.zup.simcitysaojoao.PRODUCT_KEY
import br.com.zup.simcitysaojoao.databinding.FragmentListaDeProdutosBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.produtos.adapter.ProdutoAdapter
import java.util.concurrent.RecursiveTask

class ListaDeProdutosFragment : Fragment() {
    private lateinit var binding: FragmentListaDeProdutosBinding

    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf())
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
        exibirRecyclerView()
    }


    private fun recuperarProdutoEnviado(): Produto? = arguments?.getParcelable<Produto>(PRODUCT_KEY)

    private fun inserirProdutoNaLista(): MutableList<Produto> {
        val produto = recuperarProdutoEnviado()
        val listaProdutos = mutableListOf<Produto>()
        if (produto != null) {
            listaProdutos.add(produto)
        }
        produtoAdapter.atualizarListaProdutos(listaProdutos)
        return listaProdutos
    }

    private fun exibirRecyclerView() {
        binding.rvListaProdutos.adapter = produtoAdapter
        binding.rvListaProdutos.layoutManager = LinearLayoutManager(context)
        inserirProdutoNaLista()
    }

}