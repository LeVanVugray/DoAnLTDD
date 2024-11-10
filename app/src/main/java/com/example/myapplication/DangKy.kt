package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DangKy : AppCompatActivity() {
    private lateinit var bntquaylai: Button
    private lateinit var bntdangky: Button
    private lateinit var bntdangkydangnhap:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_dangky)
        setControl()
        setEven()
    }
    private fun setControl(){
        bntquaylai = findViewById(R.id.bntquaylai)
        bntdangky = findViewById(R.id.bntdangky)
        bntdangkydangnhap = findViewById(R.id.bntdangkydangnhap)
    }
    private fun setEven() {
        bntquaylai.setOnClickListener {
            val intent = Intent(this, DangNhapKhachHang::class.java)
            startActivity(intent)
        }
        bntdangky.setOnClickListener {
            val intent = Intent(this, DangNhapKhachHang::class.java)
            startActivity(intent)
        }
        bntdangkydangnhap.setOnClickListener {
            val intent = Intent(this, DangNhapKhachHang::class.java)
            startActivity(intent)
        }
    }
}