package br.com.evjdev.gerenciadordecontaskotlin.control

import android.app.Activity
import android.widget.CheckBox
import android.widget.EditText
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.model.Despesa
import kotlinx.android.synthetic.main.activity_cadastrar_despesa.view.*

class CadastrarDespesaControl {
    val activity: Activity
    lateinit var editValor: EditText
    lateinit var editDescricao: EditText
    lateinit var editData: EditText
    lateinit var checkBoxPago: CheckBox
    val despesa: Despesa

    constructor(activity: Activity) {
        this.activity = activity

        despesa = Despesa()
    }

   fun initComponents(){
        editValor = activity.findViewById(R.id.editValor)
        editDescricao = activity.findViewById(R.id.editDesc)
        editData = activity.findViewById(R.id.editData)
        checkBoxPago = activity.findViewById(R.id.checkboxPago);


    }

    fun salvarAction(){
        val despesa = Despesa()

        despesa.valor = editValor.text.toString().toInt()
        despesa.descricao = editDescricao.text.toString()
//        despesa.data = editData.text.toString()
        despesa.pago = verificaCheckBoxPago()

    }

    fun verificaCheckBoxPago(): Boolean{
        if (checkBoxPago.isSelected){
            despesa.pago = true
        }
        return despesa.pago
    }


}