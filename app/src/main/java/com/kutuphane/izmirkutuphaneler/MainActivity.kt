package com.kutuphane.izmirkutuphaneler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kutuphane.izmirkutuphaneler.view.LibraryListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_openlist.setOnClickListener {
            val intent = Intent(this, LibraryListActivity::class.java)
            startActivity(intent)
        }
    }
}