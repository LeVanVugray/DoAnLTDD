package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuenMatKhauKhachHang : AppCompatActivity() {
    private lateinit var bntquaylai :Button
    private lateinit var bntxacnhankhachhang:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_quenmatkhau_khachhang)
        setCotrol()
        setEvent()
    }
    private fun setCotrol(){
        bntquaylai = findViewById(R.id.bntquaylai)
        bntxacnhankhachhang = findViewById(R.id.bntxacnhankhachhang)
    }
    private fun setEvent(){
        bntquaylai.setOnClickListener {
            val intent = Intent(this, DangNhapKhachHang::class.java)
            startActivity(intent)
        }
        bntxacnhankhachhang.setOnClickListener {
            val intent = Intent(this, QuenMatKhauKhachHang1::class.java)
            startActivity(intent)
        }
    }
}