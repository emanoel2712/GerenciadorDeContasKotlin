package br.com.evjdev.gerenciadordecontaskotlin.model

import java.sql.Timestamp

class Despesa {
    var valor: Number
    var descricao: String
    var data: Timestamp
    var pago: Boolean



    constructor(valor: Number, descricao: String, data: Timestamp, pago: Boolean) {
        this.valor = valor
        this.descricao = descricao
        this.data = data
        this.pago = pago
    }




}