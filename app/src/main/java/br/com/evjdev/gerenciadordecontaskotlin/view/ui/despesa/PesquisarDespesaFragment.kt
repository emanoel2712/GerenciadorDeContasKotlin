package br.com.evjdev.gerenciadordecontaskotlin.view.ui.despesa

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.model.Despesa
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout

class PesquisarDespesaFragment : Fragment() {

    lateinit var root: View

    lateinit var listDespesa: ArrayList<Despesa>

    lateinit var btAddDespesa: Button
    lateinit var recyclerViewDespesa: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_pesquisar_despesa, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//        textView.text = it

        initComponets()

        clickBtAddDespesa()

        return root
    }


    fun initComponets() {
        btAddDespesa = root.findViewById(R.id.btAddDespesa)
        recyclerViewDespesa = root.findViewById(R.id.recyclerViewDespesas)

    }

    fun clickBtAddDespesa() {
        btAddDespesa.setOnClickListener(View.OnClickListener {
            var intent = Intent(context, CadastrarDespesaActivity::class.java)
            startActivity(intent)

        })
    }

}