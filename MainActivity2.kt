package com.example.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<PropData>()
    private lateinit var adapter: PropAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = PropAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<PropData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(
            PropData(
                "Property 1",
                R.drawable.img_1,
                ""
            )
        )
        mList.add(
            PropData(
                "Property 2",
                R.drawable.img_2,
                "")
        )
        mList.add(
            PropData(
                "Property 3",
                R.drawable.img_3,
                "")
        )
        mList.add(
            PropData(
                "Property 4",
                R.drawable.img_4,
                "")
        )
        mList.add(
            PropData(
                "Property 5",
                R.drawable.img_5,
                ""
            )
        )
        mList.add(
            PropData(
                "Property 6",
                R.drawable.img_6,
                "")
        )
        mList.add(
            PropData(
                "Property 7",
                R.drawable.img_7,
                "")
        )
        mList.add(
            PropData(
                "Property 8",
                R.drawable.img_8,
                "")
        )
    }
}