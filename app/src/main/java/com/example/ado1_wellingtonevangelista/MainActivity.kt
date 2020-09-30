package com.example.ado1_wellingtonevangelista

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("listaCompras", Context.MODE_PRIVATE)
        val sp1 = getSharedPreferences("listaCompras1", Context.MODE_PRIVATE)

        btLimpar.setOnClickListener{View ->

            txtNomeProd.text.clear()
            txtCustoProd.text.clear()
            txtVendaProd.text.clear()

        }

        btCalcular.setOnClickListener{View ->

            var custo = txtCustoProd.text.toString()
            var venda = txtVendaProd.text.toString()
            var nome = txtNomeProd.text.toString()

            if(nome.isNotEmpty() && custo.isNotEmpty() && venda.isNotEmpty()){

                var result = venda.toDouble() - custo.toDouble()
                var intent = Intent(this, RespostaActivity::class.java)

                if(result < 0){

                    intent.putExtra("resposta", "Prejuízo!")
                    intent.putExtra("resultado", result)

                }else if(result > 0){

                    intent.putExtra("resposta", "Lucro!")
                    intent.putExtra("resultado", result)


                }else{

                    intent.putExtra("resposta", "Sem ganhos!")
                    intent.putExtra("resultado", result)

                }

                startActivity(intent)

            }else{

                Toast.makeText(this, "Todos os campos devem estar preenchidos", Toast.LENGTH_SHORT).show()

            }

        }

        btAbrir.setOnClickListener{View ->

            if(txtNomeProd.text.isNotEmpty()){

                var nomeProd = sp.getString(txtNomeProd.text.toString(), "")
                var custoProd = sp1.getString(txtNomeProd.text.toString(), "")


                if(nomeProd!!.isNotEmpty()){

                    txtCustoProd.setText(nomeProd)
                    txtVendaProd.setText(custoProd)

                    Toast.makeText(this, "Produto aberto", Toast.LENGTH_SHORT).show()

                }else{

                    Toast.makeText(this, "Produto vazio ou inexistente", Toast.LENGTH_SHORT).show()

                }

            }else{

                Toast.makeText(this, "Nome do produto vazio", Toast.LENGTH_SHORT).show()

            }

        }

        btSalvar.setOnClickListener{View ->

            if(txtNomeProd.text.isNotEmpty()){

                //gravar
                sp.edit().putString(txtNomeProd.text.toString(), txtCustoProd.text.toString()).apply()
                sp1.edit().putString(txtNomeProd.text.toString(), txtVendaProd.text.toString()).apply()
                Toast.makeText(this, "Produto salvo!", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(this, "É necessário ter algo salvo", Toast.LENGTH_SHORT).show()

            }

        }

    }
}