package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class QuenMatKhauadmin : AppCompatActivity() {
    private lateinit var bntxacnhanadmin:Button
    private lateinit var bntquaylai: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_quenmatkhau_admin)
        setControl()
        setEvent()

    }
    private fun setControl(){
        bntquaylai = findViewById(R.id.bntquaylai)
        bntxacnhanadmin = findViewById(R.id.bntxacnhanadmin)
    }
    private fun setEvent(){
        bntquaylai.setOnClickListener {
            val intent = Intent(this, DangNhapAdmin::class.java)
            startActivity(intent)
        }
        bntxacnhanadmin.setOnClickListener {
            val intent = Intent(this, QuenMatKhauadmin1::class.java)
            startActivity(intent)
        }
    }
}