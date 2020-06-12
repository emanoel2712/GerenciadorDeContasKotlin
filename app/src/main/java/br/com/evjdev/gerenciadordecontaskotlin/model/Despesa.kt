package br.com.evjdev.gerenciadordecontaskotlin.model

import java.sql.Timestamp

class Despesa {
    lateinit var valor: Number
    lateinit var descricao: String
    lateinit var data: Timestamp
    var pago: Boolean = false

    constructor()


    constructor(valor: Number, descricao: String, data: Timestamp, pago: Boolean) {
        this.valor = valor
        this.descricao = descricao
        this.data = data
        this.pago = pago
    }


}