package br.com.evjdev.gerenciadordecontaskotlin.view.ui.despesa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.control.CadastrarDespesaControl

class CadastrarDespesaActivity : AppCompatActivity() {

    lateinit var control: CadastrarDespesaControl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_despesa)

        control = CadastrarDespesaControl(this)
    }

//    fun salvarAction(view: View){
//        control.salvarAction()
//
//    }
}
