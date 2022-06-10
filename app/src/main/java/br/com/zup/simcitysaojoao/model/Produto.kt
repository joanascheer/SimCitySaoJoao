package br.com.zup.simcitysaojoao.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Produto(
    private val nome: String,
    private val quantidade: String,
    private val valorUnitario: String,
    private val receita: String
) : Parcelable {
    fun getNome() = this.nome
    fun getQuantidade() = this.quantidade
    fun getValorUnitario() = this.valorUnitario
    fun getReceita() = this.receita
}