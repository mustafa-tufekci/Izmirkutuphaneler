package com.kutuphane.izmirkutuphaneler.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kutuphane.izmirkutuphaneler.R
import com.kutuphane.izmirkutuphaneler.adapter.LibraryListAdapter
import com.kutuphane.izmirkutuphaneler.viewmodel.LibraryListViewModel
import kotlinx.android.synthetic.main.activity_library_list.*

class LibraryListActivity : AppCompatActivity() {
    private  var libraryViewModel = LibraryListViewModel()
    var libraryAdapter = LibraryListAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_list)

        libraryViewModel = ViewModelProvider(this).get(LibraryListViewModel::class.java)

        libraryViewModel.getLibraryList()

        libraryViewModel.libraryListLiveData.observe(this, Observer { library->
            libraryAdapter.setData(library)
        })

        var libraryList: ArrayList<String> = arrayListOf()
        libraryList.add("Karşıyaka")
        libraryList.add("Poyrazköy")
        libraryList.add("Buca")
        libraryList.add("Bostanblı")
        libraryList.add("Alaçatı")


        rv_librarylist.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_librarylist.adapter = libraryAdapter

    }
}