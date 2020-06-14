package br.com.evjdev.gerenciadordecontaskotlin.control

import android.app.Activity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
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

    private lateinit var editValor: EditText
    private lateinit var editDescricao: EditText
    private lateinit var editData: EditText
    private lateinit var checkBoxPago: CheckBox
    private lateinit var btSalvar: MaterialButton

    private lateinit var despesa: Despesa

    private lateinit var firebaseDataBase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    constructor(activity: Activity) {
        this.activity = activity

        initComponents()
    }

    private fun initComponents() {
        editValor = activity.findViewById(R.id.editValor)
        editDescricao = activity.findViewById(R.id.editDesc)
        editData = activity.findViewById(R.id.editData)
        checkBoxPago = activity.findViewById(R.id.checkboxPago);
        btSalvar = activity.findViewById(R.id.btSalvar)

        initFirebase()

        clickButtonSalvar()
    }

    private fun initFirebase() {
        FirebaseApp.initializeApp(activity);
        firebaseDataBase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDataBase.getReference()

    }

    private fun clickButtonSalvar() {
        btSalvar.setOnClickListener(View.OnClickListener {

            despesa = Despesa()

            despesa.id = UUID.randomUUID().toString();
            despesa.valor = editValor.text.toString()
            despesa.descricao = editDescricao.text.toString()

            despesa.data = editData.text.toString()
            despesa.pago = verificaCheckBoxPago(despesa)

            println("$despesa")

            databaseReference.child("Despesa").child(despesa.id).setValue(despesa)

            activity.finish()
        })

}

private fun verificaCheckBoxPago(despesa: Despesa): Boolean {

    if (checkBoxPago.isSelected) {
        despesa.pago = true
    }
    return despesa.pago
}


}