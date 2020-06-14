package br.com.evjdev.gerenciadordecontaskotlin.control

import android.app.Activity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.model.Despesa
import br.com.evjdev.gerenciadordecontaskotlin.view.ui.despesa.PesquisarDespesaFragment
import com.google.android.material.button.MaterialButton
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_cadastrar_despesa.*

import java.util.*

class CadastrarDespesaControl {
    private val activity: Activity

    private lateinit var despesa: Despesa

    private lateinit var firebaseDataBase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    constructor(activity: Activity) {
        this.activity = activity

        initFirebase()
        clickButtonSalvar()
    }

    private fun initFirebase() {
        FirebaseApp.initializeApp(activity);
        firebaseDataBase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDataBase.getReference()

    }

    private fun clickButtonSalvar() {
        activity.btSalvar.setOnClickListener() {

            despesa = Despesa()

            despesa.id = UUID.randomUUID().toString();

            despesa.valor = activity.editValor.text.toString()

            despesa.descricao = activity.editDesc.text.toString()

            despesa.data = activity.editData.text.toString()
            despesa.pago = verificaCheckBoxPago(despesa)

            if (validaDespesa(despesa)) {
                databaseReference.child("Despesa").child(despesa.id).setValue(despesa)
                activity.finish()

                println("$despesa")
            }
        }

    }

    private fun validaDespesa(despesa: Despesa): Boolean {
        if (despesa.valor.isEmpty()) {
            activity.editValor.error = "O campo valor não pode ser nulo"
            return false

        } else if (despesa.descricao.isEmpty()) {
            activity.editDesc.error = "O campo descrição não pode ser nulo"
            return false

        } else if (despesa.data.isEmpty()) {
            activity.editData.error = "O campo data não pode ser nulo"
            return false
        }
        return true
    }


    private fun verificaCheckBoxPago(despesa: Despesa): Boolean {
        if (activity.checkboxPago.isSelected) {
            despesa.pago = true
        }
        return despesa.pago
    }


}