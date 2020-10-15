package com.example.spiner

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var opciones = arrayOf("Cursiva", "Negritas", "Negritas/Cursiva")

    lateinit var spinerOpciones : Spinner
    lateinit var  txtSaludosCodigo: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinerOpciones = this.spinner
        txtSaludosCodigo = this.txtSaludos

        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,opciones)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinerOpciones.adapter = adaptador
        spinerOpciones.onItemSelectedListener = this

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p2){
            1->{
                txtSaludosCodigo.typeface = Typeface.defaultFromStyle(Typeface.ITALIC)
                txtSaludosCodigo.text = "Cursiva"
            }
            2->{
                txtSaludosCodigo.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                txtSaludosCodigo.text = "Negritas"
            }
            3->{
                txtSaludosCodigo.typeface = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC)
                txtSaludosCodigo.text = "Negritas/Cursiva"
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}