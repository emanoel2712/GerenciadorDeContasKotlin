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
        holder.tvValor.text = listDespesa[position].valor.toString()
        holder.tvDescricao.text = listDespesa[position].descricao
        holder.tvData.text = listDespesa[position].data.toString()
        holder.tvPago.text = listDespesa[position].pago.toString()

    }


    class ViewHolder : RecyclerView.ViewHolder {

//       public final lateinit var tvValor: TextView
//        lateinit var tvDescricao: TextView
//        lateinit var tvData: TextView
//        lateinit var tvPago: TextView


        constructor(itemView: View) :
                super(itemView)

        var tvValor: TextView = itemView.findViewById(R.id.tvValor)
        var tvDescricao: TextView = itemView.findViewById(R.id.tvDesc)
        var tvData: TextView = itemView.findViewById(R.id.tvData)
        var tvPago: TextView = itemView.findViewById(R.id.tvPago)
    }
}