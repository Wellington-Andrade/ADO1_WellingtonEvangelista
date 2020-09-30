package com.example.ado1_wellingtonevangelista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resposta.*

class RespostaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)

        var resposta = intent.getStringExtra("resposta")
        var resultado = intent.getDoubleExtra("resultado", 0.00)
        txtRespostaText.setText(resposta)
        txtRespostaNum.setText(resultado.toString())

    }
}