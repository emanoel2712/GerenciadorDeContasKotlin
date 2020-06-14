package br.com.evjdev.gerenciadordecontaskotlin.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.model.Despesa
import kotlinx.android.synthetic.main.view_despesa.view.*

class DespesaAdapter : RecyclerView.Adapter<DespesaAdapter.ViewHolder> {

    private val listDespesa: ArrayList<Despesa>
    private val context: Context

    constructor(context: Context, listDespesa: ArrayList<Despesa>) : super() {
        this.listDespesa = listDespesa
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.view_despesa, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDespesa.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvValor.text = listDespesa[position].valor
        holder.itemView.tvDesc.text = listDespesa[position].descricao
        holder.itemView.tvData.text = listDespesa[position].data
        holder.itemView.tvPago.text = listDespesa[position].pago.toString()

    }


    class ViewHolder: RecyclerView.ViewHolder{

        constructor(itemView: View) :
                super(itemView)



    }
}