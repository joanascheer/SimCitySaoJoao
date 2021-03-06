package br.com.zup.simcitysaojoao.produtos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutoItemBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProdutoAdapter(
    private var listaProdutos: ArrayList<Produto>,
    private val clickProduto: (produto: Produto) -> Unit,
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProdutos[position]
        holder.exibirDados(produto)
        holder.binding.cvItemLista.setOnClickListener {
            clickProduto(produto)
        }
    }

    override fun getItemCount(): Int = listaProdutos.size

    fun atualizarListaProdutos(novaListaProduto: ArrayList<Produto>) {
        if (listaProdutos.size == 0) {
            listaProdutos.addAll(novaListaProduto)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirDados(produto: Produto) {
            binding.tvQuantidadeProdutosCv.text = produto.getQuantidade().toString()
            binding.tvNomeProdutosCv.text = produto.getNome()

        }
    }

}