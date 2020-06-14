package br.com.evjdev.gerenciadordecontaskotlin.model


import java.io.Serializable
import java.sql.Timestamp
import java.util.*


data class Despesa(
    var id: String = "",
    var valor: String = "",
    var descricao: String = "",
    var data: String = "",
    var pago: Boolean = false
) : Serializable {

    override fun toString(): String {
        return "Despesa(id='$id', valor='$valor', descricao='$descricao', data='$data', pago=$pago)"
    }

}