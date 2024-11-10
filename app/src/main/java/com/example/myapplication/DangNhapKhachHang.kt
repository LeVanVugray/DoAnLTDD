package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DangNhapKhachHang : AppCompatActivity() {
    private lateinit var bntqualai: Button
    private lateinit var bntdangkykhach:Button
    private lateinit var bntquenmk:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_dangnhap_khachhang)
        setControl()
        setEven()
    }
    private fun setControl(){
        bntqualai = findViewById(R.id.bntquaylai)
        bntdangkykhach = findViewById(R.id.bntdangkykhach)
        bntquenmk = findViewById(R.id.bntquenmk)

    }
    private fun setEven() {
        bntqualai.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
        }
        bntdangkykhach.setOnClickListener {
            val intent = Intent(this, DangKy::class.java)
            startActivity(intent)
        }
        bntquenmk.setOnClickListener {
            val intent = Intent(this, QuenMatKhauKhachHang::class.java)
            startActivity(intent)
        }

    }
}