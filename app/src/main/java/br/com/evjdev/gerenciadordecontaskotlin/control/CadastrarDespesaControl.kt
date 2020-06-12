package br.com.evjdev.gerenciadordecontaskotlin.control

import android.app.Activity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.model.Despesa
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_cadastrar_despesa.view.*
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class CadastrarDespesaControl {
    val activity: Activity

    lateinit var editValor: EditText
    lateinit var editDescricao: EditText
    lateinit var editData: EditText
    lateinit var checkBoxPago: CheckBox
    lateinit var btSalvar: Button

    val despesa: Despesa

    lateinit var firebaseDataBase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference

    constructor(activity: Activity) {
        this.activity = activity

        despesa = Despesa()

        initComponents()
    }

    fun initComponents() {
        editValor = activity.findViewById(R.id.editValor)
        editDescricao = activity.findViewById(R.id.editDesc)
        editData = activity.findViewById(R.id.editData)
        checkBoxPago = activity.findViewById(R.id.checkboxPago);
        btSalvar = activity.findViewById(R.id.btSalvar)

        initFirebase()

        clickButtonSalvar()
    }

    fun initFirebase() {
        FirebaseApp.initializeApp(activity);
        firebaseDataBase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDataBase.getReference()

    }

    fun clickButtonSalvar() {
        btSalvar.setOnClickListener(View.OnClickListener {
            despesa.id = UUID.randomUUID().toString();
            despesa.valor = editValor.text.toString().toInt()
            despesa.descricao = editDescricao.text.toString()

//            val date = LocalDate.parse(editData.text, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
//            val unix = l.atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond
            val date = SimpleDateFormat("dd-MM-yyyy").parse(editData.text.toString())

//            despesa.data = java.dvalueOf(string)
                editData.text.toString()

            despesa.data = (date as? Timestamp)!!


            despesa.pago = verificaCheckBoxPago()

            println("$despesa")


            databaseReference.child("Despesa").child(despesa.id).setValue(despesa)

            activity.finish()
        })

    }

    fun verificaCheckBoxPago(): Boolean {
        if (checkBoxPago.isSelected) {
            despesa.pago = true
        }
        return despesa.pago
    }


}