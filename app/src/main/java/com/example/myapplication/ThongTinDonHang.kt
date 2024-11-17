package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat


class ThongTinDonHang : AppCompatActivity() {

    private lateinit var imgQuayLai: ImageView
    private lateinit var txtGia: TextView
    private lateinit var btnHuy: Button
    private lateinit var txtThongTin: TextView
    private lateinit var txtTrangThai: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thong_tin_dh)

        // Ánh xạ các view
        imgQuayLai = findViewById(R.id.ImgQuayLai)
        txtGia = findViewById(R.id.txtGia)
        btnHuy = findViewById(R.id.btnHuy)
        txtThongTin = findViewById(R.id.textView13)
        txtTrangThai = findViewById(R.id.textView14)

        // Nhận giá trị tổng tiền từ Intent
        val totalPayment = intent.getIntExtra("total_payment", 0)

        // Kiểm tra xem giá trị totalPayment có hợp lệ hay không
        if (totalPayment != 0) {
            txtGia.text = formatCurrency(totalPayment)
        } else {
            txtGia.text = "Không có giá trị hợp lệ"
        }

        // Đặt sự kiện cho nút "Quay lại"
        imgQuayLai.setOnClickListener {
            finish() // Kết thúc Activity và quay lại màn hình trước đó
        }

        // Đặt sự kiện cho nút "Hủy"
        btnHuy.setOnClickListener {
            val intent = Intent(this, HuyDon::class.java)
            intent.putExtra("total_payment", totalPayment)  // Truyền giá trị totalPayment
            startActivity(intent)
        }

        // Thiết lập thông tin ban đầu cho `txtThongTin`
        txtThongTin.text = "Thông tin đơn hàng"

        // Thiết lập trạng thái ban đầu cho TextView trạng thái
        txtTrangThai.text = "Chờ xác nhận"
    }

    // Định dạng tiền tệ
    private fun formatCurrency(amount: Int): String {
        // Sử dụng DecimalFormat để định dạng tiền với dấu phẩy
        val decimalFormat = DecimalFormat("#,###")
        return "${decimalFormat.format(amount)} đ"
    }
}
