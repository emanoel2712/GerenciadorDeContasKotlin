package br.com.evjdev.gerenciadordecontaskotlin.model

import java.sql.Timestamp
import java.util.*

class Despesa {
    lateinit var id:  String
    lateinit var valor: Number
    lateinit var descricao: String
    lateinit var data: Timestamp
    var pago: Boolean = false

    constructor()


    constructor(id: String, valor: Number, descricao: String, data: Timestamp, pago: Boolean) {
        this.id = id;
        this.valor = valor
        this.descricao = descricao
        this.data = data
        this.pago = pago
    }

    override fun toString(): String {
        return "Despesa(id='$id', valor=$valor, descricao='$descricao', data=$data, pago=$pago)"
    }


}