package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuenMatKhauadmin1 : AppCompatActivity() {
    private lateinit var bntquaylai: Button
    private lateinit var bntxacnhanadmin1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_quenmatkhau_admin1)
        setControl()
        setEvent()
    }
    private fun setControl(){
        bntquaylai = findViewById(R.id.bntquaylai)
        bntxacnhanadmin1 = findViewById(R.id.bntxacnhanadmin1)
    }
    private fun setEvent(){
        bntquaylai.setOnClickListener {
            val intent = Intent(this, QuenMatKhauadmin::class.java)
            startActivity(intent)
        }
        bntxacnhanadmin1.setOnClickListener {
            val intent = Intent(this, DangNhapAdmin::class.java)
            startActivity(intent)
        }
    }
}