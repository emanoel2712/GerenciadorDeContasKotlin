package br.com.evjdev.gerenciadordecontaskotlin.model

import java.sql.Timestamp

class Despesa {
    var number: String
    var descricao: String
    var data: Timestamp
    var pago: Boolean

    constructor(number: String, descricao: String, data: Timestamp, pago: Boolean) {
        this.number = number;
        this.descricao = descricao;
        this.data = data;
        this.pago = pago;
    }


}