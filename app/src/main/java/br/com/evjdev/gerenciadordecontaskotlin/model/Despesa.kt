package br.com.evjdev.gerenciadordecontaskotlin.model

import java.sql.Timestamp

class Despesa {
    val valor: Number
    val descricao: String
    val data: Timestamp
    val pago: Boolean



    constructor(valor: Number, descricao: String, data: Timestamp, pago: Boolean) {
        this.valor = valor
        this.descricao = descricao
        this.data = data
        this.pago = pago
    }




}