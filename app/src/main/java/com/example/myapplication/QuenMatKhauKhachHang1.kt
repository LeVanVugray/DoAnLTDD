package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuenMatKhauKhachHang1 : AppCompatActivity() {
    private lateinit var bntquaylai : Button
    private lateinit var bntxacnhankhachhang1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_quenmatkhau_khachhang1)
        setCotrol()
        setEvent()
    }
    private fun setCotrol(){
        bntquaylai = findViewById(R.id.bntquaylai)
        bntxacnhankhachhang1 = findViewById(R.id.bntxacnhankhachhang1)
    }
    private fun setEvent(){
        bntquaylai.setOnClickListener {
            val intent = Intent(this, QuenMatKhauKhachHang::class.java)
            startActivity(intent)
        }
        bntxacnhankhachhang1.setOnClickListener {
            val intent = Intent(this, DangNhapKhachHang::class.java)
            startActivity(intent)
        }
    }
}