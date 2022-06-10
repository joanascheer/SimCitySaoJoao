package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.simcitysaojoao.databinding.FragmentDetalhesDeProdutosBinding

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
    }

}