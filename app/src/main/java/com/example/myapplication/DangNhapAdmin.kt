package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class DangNhapAdmin : AppCompatActivity() {
    private lateinit var bntqualai: Button
    private lateinit var bntquenmkadmin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_dangnhap_admin)
        setControl()
        setEven()


    }
    private fun setControl(){
        bntqualai = findViewById(R.id.bntquaylai)
        bntquenmkadmin = findViewById(R.id.bntquenmkadmin)

    }
    private fun setEven() {
        bntqualai.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
        }
        bntquenmkadmin.setOnClickListener {
            val intent = Intent(this, QuenMatKhauadmin::class.java)
            startActivity(intent)
        }
    }
}