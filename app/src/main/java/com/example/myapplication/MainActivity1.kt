package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {
    private lateinit var bntadmin: Button
    private lateinit var bntkhachhang: Button

//    private lateinit var bntchuyen: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_dangnhap_admin_khachhang)
        setControl()
        setEven()

    }
    private fun setControl(){
        bntadmin = findViewById(R.id.bntadmin)
        bntkhachhang = findViewById(R.id.bntkhachhang)

//        bntchuyen = findViewById(R.id.buttonchuyen)

    }
    private fun setEven(){
        bntadmin.setOnClickListener{
            val intent = Intent(this,DangNhapAdmin::class.java)
            startActivity(intent)
        }
        bntkhachhang.setOnClickListener{
            val intent = Intent(this,DangNhapKhachHang::class.java)
            startActivity(intent)
        }
//        bntchuyen.setOnClickListener{
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }

    }


}