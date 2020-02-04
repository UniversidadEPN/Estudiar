package com.example.estudiar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun irBase(View: View){
        var base= Intent(this, BaseDatos::class.java)
        base.putExtra("nombre", editText.text.toString())
        startActivity(base)

    }


}
