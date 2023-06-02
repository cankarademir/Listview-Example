package com.example.cankarademirodev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtveri1: EditText
    lateinit var btnEkle1: Button
    lateinit var txtveri2: EditText
    lateinit var btnEkle2: Button
    lateinit var btnsonuc: Button
    var list1 = arrayListOf<String>()
    var list2 = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtveri1 = findViewById(R.id.txtveri1)
        btnEkle1 = findViewById(R.id.btnEkle1)
        txtveri2 = findViewById(R.id.txtveri2)
        btnEkle2 = findViewById(R.id.btnEkle2)
        btnsonuc = findViewById(R.id.btnSonuc)

        //1. ekleme listesine veriyi ekleyince 1. arraylistimize eklem yapıyor
        btnEkle1.setOnClickListener {
            val item =txtveri1.text.toString()
            if (item.length==0){
                Toast.makeText(this, "Boş veri eklenemez", Toast.LENGTH_LONG).show()
            } else {
                list1.add(item)
                txtveri1.text.clear()
            }
        }
        //2. ekleme listesine veriyi ekleyince 2. arraylistimize eklem yapıyor
        btnEkle2.setOnClickListener {
            val item1 =txtveri2.text.toString()
            if (item1.length==0){
                Toast.makeText(this, "Boş veri eklenemez", Toast.LENGTH_LONG).show()
            } else{
                list2.add(item1)
                txtveri2.text.clear()
            }
        }

        //sonuç butonuna tıklayınca activity_result sayfasına yönlendirme yapılır, list1 ve list2 arraylistleri put edilir.
        btnsonuc.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            intent.putStringArrayListExtra("list1",list1)
            intent.putStringArrayListExtra("list2", list2)

            if (list1.size ==0 && list2.size==0) {
                Toast.makeText(this, "Veri yok lütfen veri ekleyiniz", Toast.LENGTH_LONG).show()
            }
            else{
                startActivity(intent)
            }
        }
    }
}