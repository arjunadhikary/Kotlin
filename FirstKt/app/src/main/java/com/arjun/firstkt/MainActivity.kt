package com.arjun.firstkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0;
    private lateinit var counter:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab:FloatingActionButton = findViewById(R.id.fab)
         val delete:FloatingActionButton = findViewById(R.id.delete)
        delete.setOnClickListener { counter.text= 0.toString() }
        counter = findViewById(R.id.counter)
        fab.setOnClickListener {
            counter.text = count++.toString()
            counter.alpha = 1f
        }
        fab.setOnLongClickListener(){view->
            count+=10
            Snackbar.make(view,"Hurray Value increased by 10",Snackbar.LENGTH_SHORT).setAction("undo"
            ) {
                count -= 10
                counter.text = count.toString()
            }.show()
            counter.text = count.toString()
            return@setOnLongClickListener true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("value",count)
        Log.e("TAG", "onSaveInstanceState:${count} ")
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("value")
        counter.alpha = 1f
        counter.text = count.toString()
        Log.e("TAG", "onSaveInstanceState:${count} ")

    }


}