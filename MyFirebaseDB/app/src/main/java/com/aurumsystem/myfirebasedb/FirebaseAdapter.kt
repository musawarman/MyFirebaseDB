package com.aurumsystem.myfirebasedb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FirebaseAdapter(private val listDataku:ArrayList<FirebaseDataClassView>):
    RecyclerView.Adapter<FirebaseAdapter.FirebaseViewHolder>()
{
    inner class FirebaseViewHolder(myView: View):RecyclerView.ViewHolder(myView)
    {
        var tvName:TextView = myView.findViewById(R.id.tv_name)
        var tvPrice:TextView = myView.findViewById(R.id.tv_price)
        var btnEdit: ImageButton = myView.findViewById(R.id.btn_data_edit)
        var btnDel:ImageButton = myView.findViewById(R.id.btn_data_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirebaseViewHolder {
        val viewKu:View = LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        return FirebaseViewHolder(viewKu)
    }

    override fun onBindViewHolder(holder: FirebaseViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvName.text = dataku.name
        holder.tvPrice.text = dataku.price.toDouble().toString()
    }

    override fun getItemCount(): Int {
        return listDataku.size
    }


}