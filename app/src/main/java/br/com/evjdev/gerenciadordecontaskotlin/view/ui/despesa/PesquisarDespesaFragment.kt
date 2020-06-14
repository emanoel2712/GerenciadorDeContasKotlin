package br.com.evjdev.gerenciadordecontaskotlin.view.ui.despesa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.adapter.DespesaAdapter
import br.com.evjdev.gerenciadordecontaskotlin.control.PesquisarDespesaControl
import br.com.evjdev.gerenciadordecontaskotlin.model.Despesa
import com.google.android.material.button.MaterialButton
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*


class PesquisarDespesaFragment : Fragment() {

    private lateinit var pesquisarDespesaControl: PesquisarDespesaControl

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_pesquisar_despesa, container, false)

        pesquisarDespesaControl = PesquisarDespesaControl(root, this)



        return root
    }

}






