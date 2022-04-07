package com.aurumsystem.myfirebasedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    lateinit var fire:DatabaseReference
    private lateinit var layoutku:RecyclerView
    private var ambilDatabase:ArrayList<FirebaseDataClassView> = arrayListOf()
    lateinit var btnAdd:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutku = findViewById(R.id.rv_data)
        fire = FirebaseDatabase.getInstance().getReference("Drink")
    }
    override fun onStart(){
        super.onStart()
        loadMeFirst()
    }
    private fun loadMeNow(){
        layoutku.layoutManager = LinearLayoutManager(this)
        val MyAdapter = FirebaseAdapter(ambilDatabase)
        layoutku.adapter = MyAdapter
    }
    private fun loadMeFirst(){
        fire.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot){
                if(snapshot!!.exists()){
                    ambilDatabase.clear()
                    for(x in snapshot.children){
                        val mydata = x.getValue(FirebaseDataClassView::class.java)
                        mydata!!.uid = x.key.toString()
                        ambilDatabase.add(mydata)
                    }
                }
                loadMeNow()
            }

            override fun onCancelled(error: DatabaseError) {
                
            }
        })
    }
}