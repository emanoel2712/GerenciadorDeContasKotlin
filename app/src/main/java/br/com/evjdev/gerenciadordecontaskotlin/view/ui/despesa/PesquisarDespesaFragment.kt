package br.com.evjdev.gerenciadordecontaskotlin.view.ui.despesa

import android.content.Intent
import android.os.Bundle
import android.renderscript.Sampler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.adapter.DespesaAdapter
import br.com.evjdev.gerenciadordecontaskotlin.model.Despesa
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*




class PesquisarDespesaFragment : Fragment() {

    private lateinit var root: View

    var listDespesa: ArrayList<Despesa>? = ArrayList()

//  private var listDespesa: ArrayList<Despesa> = ArrayList()

    private lateinit var btAddDespesa: MaterialButton
    private lateinit var recyclerViewDespesa: RecyclerView

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference


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

    private fun initComponets() {
        btAddDespesa = root.findViewById(R.id.btAddDespesa)
        recyclerViewDespesa = root.findViewById(R.id.recyclerViewDespesas)

        initFirebase()
        recuperarDespesasBanco()
        setupRecyclerView()

    }

    private fun clickBtAddDespesa() {
        btAddDespesa.setOnClickListener(View.OnClickListener {
            var intent = Intent(context, CadastrarDespesaActivity::class.java)
            startActivity(intent)

        })
    }

    private fun initFirebase() {
        activity?.applicationContext?.let { FirebaseApp.initializeApp(it) }
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference()

    }

    private fun recuperarDespesasBanco() {
        var query: Query = databaseReference.child("Despesa")
//        query.addValueEventListener(val v = ValueEventListener())

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val despesa: Despesa = snapshot.getValue(Despesa::class.java)!!

                    listDespesa?.add(despesa)

                    println("$listDespesa")
                }

            }

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context, "Erro ao recuperar dados do banco", Toast.LENGTH_SHORT)
            }


        });

    }

    private fun setupRecyclerView() {
        recyclerViewDespesa.setHasFixedSize(true)
        recyclerViewDespesa.setLayoutManager(LinearLayoutManager(root.context))
        recyclerViewDespesa.setAdapter(listDespesa?.let { DespesaAdapter(root.context, it) })
//        recyclerViewDespesa.layoutManager(object : LinearLayoutManager(context))

    }




}