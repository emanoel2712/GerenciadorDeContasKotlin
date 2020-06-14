package br.com.evjdev.gerenciadordecontaskotlin.view.ui.receita

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.evjdev.gerenciadordecontaskotlin.R

class PesquisarReceitaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_pesquisar_receita, container, false)



        return root
    }
}