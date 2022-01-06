package com.kutuphane.izmirkutuphaneler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kutuphane.izmirkutuphaneler.R
import com.kutuphane.izmirkutuphaneler.model.LibraryListResponse
import kotlinx.android.synthetic.main.library_list_item_layout.view.*

class LibraryListAdapter() : RecyclerView.Adapter<LibraryListAdapter.LibraryListHolder>() {

    var libraryList: ArrayList<LibraryListResponse.LibraryListResponseItem> = arrayListOf()

    // tasarımı vericek kısım
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryListAdapter.LibraryListHolder =
        LibraryListHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.library_list_item_layout, parent, false)
        )

    override fun onBindViewHolder(holder: LibraryListAdapter.LibraryListHolder, position: Int) {
        //detayı vericek kısım
        holder.bind(libraryList[position])
    }

    override fun getItemCount(): Int = libraryList.size

    inner class LibraryListHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(isim: LibraryListResponse.LibraryListResponseItem) {
            itemView.tv_library_name.text = isim.toString()
        }
    }

    fun setData(libraryResponse: ArrayList<LibraryListResponse.LibraryListResponseItem>){
        libraryList.addAll(libraryResponse)
        notifyDataSetChanged()
    }


}