package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HuyDon : AppCompatActivity() {

    // Ánh xạ các view
    private lateinit var imgVe: ImageView
    private lateinit var txtThongTin: TextView
    private lateinit var txtTrangThai: TextView
    private lateinit var btnMuaLai: Button
    private lateinit var txtGia: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.huy_don) // Sử dụng tên layout XML bạn đã tạo

        // Ánh xạ các View
        imgVe = findViewById(R.id.ImgVe)
        txtThongTin = findViewById(R.id.textView28)
        txtTrangThai = findViewById(R.id.textView35)
        btnMuaLai = findViewById(R.id.btnMuaLai)
        txtGia = findViewById(R.id.textView26) // Hiển thị thông tin giá sản phẩm

        // Đặt sự kiện cho nút "Quay lại"
        imgVe.setOnClickListener {
            finish()  // Quay lại màn hình trước đó
        }

        // Đặt sự kiện cho nút "Mua lại"
        btnMuaLai.setOnClickListener {
            // Xử lý khi người dùng nhấn "Mua lại"
            val intent = Intent(this, TrangChuGioHang::class.java)

            // Truyền lại thông tin đơn hàng
            intent.putExtra("total_price", 350000)  // Truyền giá trị đơn hàng, ví dụ 350,000 đ
            intent.putExtra("customer_name", "Nguyễn Văn A")  // Thêm thông tin khách hàng nếu cần
            intent.putExtra("customer_phone", "0123456789")
            intent.putExtra("customer_address", "Địa Ngục")

            // Mở màn hình thanh toán và giữ nguyên số tiền
            startActivity(intent)
        }

        // Thiết lập giá trị mặc định cho các TextView
        txtThongTin.text = "Thông Tin Đơn Hàng"
        txtTrangThai.text = "Đơn Đã Hủy"
        txtGia.text = formatCurrency(350000)  // Giả sử giá trị sản phẩm là 350,000đ
    }

    // Định dạng tiền tệ
    private fun formatCurrency(amount: Int): String {
        return "${amount.toString().replace( "(\\d)(?=(\\d{3})+\\b)", "$1," )} đ"
    }
}
