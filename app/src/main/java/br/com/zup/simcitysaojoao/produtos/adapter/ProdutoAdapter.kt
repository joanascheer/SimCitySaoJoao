package br.com.zup.simcitysaojoao.produtos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutoItemBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProdutoAdapter(
    private var listaProdutos: MutableList<Produto>,
//private val clickProduto:(produto: Produto) -> Unit,
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProdutos[position]
        holder.exibirDados(produto)
        //aqui vai a função de click no item
    }

    override fun getItemCount(): Int = listaProdutos.size

    fun atualizarListaProdutos(novaListaProduto: MutableList<Produto>) {
        if (listaProdutos.size == 0) {
            listaProdutos = novaListaProduto
        } else {
            listaProdutos.addAll(novaListaProduto)
        }
        notifyDataSetChanged()
    }


    class ViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun exibirDados(produto: Produto) {
            binding.tvQuantidadeProdutosCv.text = produto.getQuantidade()
            binding.tvNomeProdutosCv.text = produto.getNome()
        }

    }

}