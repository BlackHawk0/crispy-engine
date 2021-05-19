package com.example.betterway

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstActivity : AppCompatActivity(), OnCategoryClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        supportActionBar?.setTitle(R.string.first_activity)
        supportActionBar?.title = "First Activity"


        val rv = findViewById<RecyclerView>(R.id.recyler_view)

        rv.layoutManager = GridLayoutManager(this,2 )
        val firstAdapter= FirstAdapter(this,getItemsList(),this)
        rv.adapter= firstAdapter



    }
    private fun getItemsList(): ArrayList<Model>{
        val list = ArrayList<Model>()


            list.add(Model( "Family"))
            list.add(Model( "Friends"))
            list.add(Model( "Tutors"))
            list.add(Model( "Colleagues"))
            list.add(Model( "Church Members"))
            list.add(Model( "Clients"))


        return  list
    }

    override fun onCategoryItemClicked(position: Int) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(NAME_EXTRAs, 1)

        this.startActivity(intent)
    }
    companion object{
        const val NAME_EXTRAs = "name_extras"

    }
}