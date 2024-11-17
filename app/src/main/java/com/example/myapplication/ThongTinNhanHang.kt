package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThongTinNhanHang : AppCompatActivity() {

    private lateinit var edtTenKH: EditText
    private lateinit var edtPhone: EditText
    private lateinit var edtDiaChi: EditText
    private lateinit var btnOK: Button
    private lateinit var btnQuayLai: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thong_tin_kh)

        // Khởi tạo các component giao diện
        edtTenKH = findViewById(R.id.edtTenKH)
        edtPhone = findViewById(R.id.edtPhone)
        edtDiaChi = findViewById(R.id.edtDiaChi)
        btnOK   = findViewById(R.id.btnOK)
        btnQuayLai = findViewById(R.id.btnQuayLai)

        btnOK.setOnClickListener {
            val name = edtTenKH.text.toString()
            val phone = edtPhone.text.toString()
            val address = edtDiaChi.text.toString()

            // Check for valid data
            if (name.isNotEmpty() && phone.isNotEmpty() && address.isNotEmpty()) {
                val totalPrice = 100000 // Example total price (replace with actual calculation)
                val additionalFee = 220000

                // Add the additional fee to the total price
                val totalPayment = totalPrice + additionalFee;

                // Intent to ThanhToan activity
                val intent = Intent(this, ThanhToan::class.java)
                intent.putExtra("customer_name", name)
                intent.putExtra("customer_phone", phone)
                intent.putExtra("customer_address", address)
                intent.putExtra("total_price", totalPayment)  // Send updated total price
                startActivity(intent)
            } else {
                // Show message for missing information
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show()
            }
        }

        // Xử lý sự kiện nhấn nút "Quay lại"
        btnQuayLai.setOnClickListener {
            finish() // Quay lại màn hình trước đó
        }
    }
}
