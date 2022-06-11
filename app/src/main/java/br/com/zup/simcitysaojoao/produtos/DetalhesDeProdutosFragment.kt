package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.simcitysaojoao.PRODUCT_KEY
import br.com.zup.simcitysaojoao.databinding.FragmentDetalhesDeProdutosBinding
import br.com.zup.simcitysaojoao.model.Produto

class DetalhesDeProdutosFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesDeProdutosBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalhesDeProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarDadosProduto()
    }

    private fun recuperarDadosProduto() {
        val produto = arguments?.getParcelable<Produto>(PRODUCT_KEY)
        if (produto != null) {
            binding.tvNomeProdutoTelaDetalhes.text = produto.getNome()
            binding.tvQuantidadeProdutoTelaDetalhes.text = produto.getQuantidade().toString()
            binding.tvValorProdutoTelaDetalhes.text = produto.getValorUnitario().toString()
            binding.tvReceitaProdutoTelaDetalhes.text = produto.getReceita()
        }
    }

}