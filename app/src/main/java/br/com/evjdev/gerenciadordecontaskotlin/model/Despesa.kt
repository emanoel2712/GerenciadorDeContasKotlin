package br.com.evjdev.gerenciadordecontaskotlin.model


import java.io.Serializable
import java.sql.Timestamp
import java.util.*


class Despesa: Serializable {
     lateinit var id:  String
     lateinit var valor: String
     lateinit var descricao: String
     lateinit var data: String
     var pago: Boolean = false

    constructor()

    override fun toString(): String {
        return "Despesa(id='$id', valor=$valor, descricao='$descricao', data=$data, pago=$pago)"
    }


}