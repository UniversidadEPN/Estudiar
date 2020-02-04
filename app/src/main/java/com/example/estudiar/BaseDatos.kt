package com.example.estudiar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.IntegerRes
import com.google.common.primitives.UnsignedBytes.toInt
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_base_datos.*
import kotlin.properties.Delegates

class BaseDatos : AppCompatActivity() {


    internal lateinit var db: FirebaseFirestore
    internal lateinit var nomb: String
    internal lateinit var apell: String
    internal var edad by Delegates.notNull<Int>()
    internal lateinit var celu: String

    internal lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_datos)

        db = FirebaseFirestore.getInstance()


        val datoAnterior: Intent = intent
        var texto =datoAnterior.getStringExtra("nombre")
        textView.text= "$texto"
/*
        nomb= textView.text.toString()

        apell= editTextApellido.text.toString()
        edad =editTextEdad.text.toString().toInt()
        celu= editTextCelular.text.toString()

*/
        btnStart = findViewById(R.id.button2)

        btnStart.setOnClickListener(View.OnClickListener {
            nomb= textView.text.toString()
            apell= editTextApellido.text.toString()
            edad =editTextEdad.text.toString().toInt()
            celu= editTextCelular.text.toString()

            addUsuario()
        })


        //addUsuario()

    }

    private fun addUsuario() {
        db.collection("usuarios").whereEqualTo("apellido", apell).get().addOnSuccessListener {
            queryDocumentSnapshots ->
            if(queryDocumentSnapshots.size()>0){
                editTextApellido.error= "El apellido esta mal"
            }else{
                addApellidoToFirestore()


            }
        }


    }

    private fun addApellidoToFirestore() {
        val nuevoUsuario = Usuario(nomb,apell, edad, celu)


        db.collection("usuarios").add(nuevoUsuario).addOnSuccessListener {
            //documentReference ->
            //instruccion extra
        }

    }


}
