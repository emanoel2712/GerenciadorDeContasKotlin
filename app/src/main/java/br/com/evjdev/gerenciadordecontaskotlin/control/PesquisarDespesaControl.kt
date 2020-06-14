package br.com.evjdev.gerenciadordecontaskotlin.control

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.adapter.DespesaAdapter
import br.com.evjdev.gerenciadordecontaskotlin.model.Despesa
import br.com.evjdev.gerenciadordecontaskotlin.view.ui.despesa.CadastrarDespesaActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*

class PesquisarDespesaControl {
    private val root: View
    private val fragment: Fragment


    val listDespesa: ArrayList<Despesa> = ArrayList()

    private lateinit var btAddDespesa: MaterialButton
    private lateinit var recyclerViewDespesa: RecyclerView

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference


    constructor(root: View, fragment: Fragment) {
        this.root = root
        this.fragment = fragment

        initComponents()

    }

    private fun initComponents() {
        btAddDespesa = root.findViewById(R.id.btAddDespesa)
        recyclerViewDespesa = root.findViewById(R.id.recyclerViewDespesas)

        initFirebase()
        recuperarDespesasBanco()
        setupRecyclerView()
        clickBtAddDespesa()

    }

    private fun clickBtAddDespesa() {
        btAddDespesa.setOnClickListener {
            val intent = Intent(root.context, CadastrarDespesaActivity::class.java)
            fragment.startActivity(intent)


        }

    }

    private fun initFirebase() {
        FirebaseApp.initializeApp(root.context)
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference()

    }

    private fun recuperarDespesasBanco() {
        val query: Query = databaseReference.child("Despesa")

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val despesa: Despesa = snapshot.getValue(Despesa::class.java)!!

                    listDespesa.add(despesa)
                    recyclerViewDespesa.adapter?.notifyDataSetChanged()

                    println("$listDespesa")
                }

            }

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(root.context, "Erro ao recuperar dados do banco", Toast.LENGTH_SHORT)
            }


        });
    }

    private fun setupRecyclerView() {
        recyclerViewDespesa.setHasFixedSize(true)
        recyclerViewDespesa.layoutManager = LinearLayoutManager(root.context)
        recyclerViewDespesa.adapter =
            DespesaAdapter(root.context, listDespesa)

        println("listadespesa2: $listDespesa")

    }



}