package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhuongThucThanhToan : AppCompatActivity() {

    private lateinit var txtTrucTiep: TextView
    private lateinit var txtThe: TextView
    private lateinit var txtApplepay: TextView
    private lateinit var btnDongY: Button
    private lateinit var btnQuayLai: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phuong_thuc_thanh_toan)

        // Khởi tạo các component giao diện
        txtTrucTiep = findViewById(R.id.txtTrucTiep)
        txtThe = findViewById(R.id.txtThe)
        txtApplepay = findViewById(R.id.txtApplepay)
        btnDongY = findViewById(R.id.btnDongY)
        btnQuayLai = findViewById(R.id.btnQuayLai)

        // Xử lý sự kiện nhấn "Đồng ý"
        btnDongY.setOnClickListener {
            val selectedPaymentMethod = when {
                txtTrucTiep.isSelected -> txtTrucTiep.text.toString()
                txtThe.isSelected -> txtThe.text.toString()
                txtApplepay.isSelected -> txtApplepay.text.toString()
                else -> "Chưa chọn phương thức"
            }

            // Gửi kết quả về Activity ThanhToan
            val resultIntent = Intent()
            resultIntent.putExtra("selected_payment_method", selectedPaymentMethod)
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Đóng Activity và quay lại ThanhToanActivity
        }

        // Quay lại nếu nhấn nút Quay lại
        btnQuayLai.setOnClickListener {
            finish()
        }

        // Thiết lập các sự kiện chọn phương thức thanh toán
        txtTrucTiep.setOnClickListener { selectPaymentMethod(txtTrucTiep) }
        txtThe.setOnClickListener { selectPaymentMethod(txtThe) }
        txtApplepay.setOnClickListener { selectPaymentMethod(txtApplepay) }
    }

    // Phương thức chọn phương thức thanh toán
    private fun selectPaymentMethod(paymentMethod: TextView) {
        // Deselect tất cả các phương thức thanh toán
        txtTrucTiep.isSelected = false
        txtThe.isSelected = false
        txtApplepay.isSelected = false

        // Chọn phương thức thanh toán được nhấn
        paymentMethod.isSelected = true
    }
}
