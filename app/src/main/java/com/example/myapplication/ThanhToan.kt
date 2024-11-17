package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class ThanhToan : AppCompatActivity() {

    private lateinit var txtTenKH: TextView
    private lateinit var txtPhone: TextView
    private lateinit var txtDiaChi: TextView
    private lateinit var ImgThongTinKH: ImageView
    private lateinit var txtTongTienSP: TextView
    private lateinit var txtTongTienVanChuyen: TextView
    private lateinit var txtTongTien: TextView
    private lateinit var txtTongThanhToan: TextView
    private lateinit var txtPhuongThucThanhToan: TextView
    private lateinit var baohiemthoitrang: CheckBox
    private lateinit var btnHang: Button
    private lateinit var btnQuayLai: ImageButton

    private var finalTotal = 0
    private val shippingPrice = 30000
    private val insurancePrice = 300
    private val additionalFee = 220000
    private val PAYMENT_METHOD_REQUEST_CODE = 1001 // Request code for payment method

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thanh_toan)

        // Khởi tạo các component giao diện
        txtTenKH = findViewById(R.id.txtTenKH)
        txtPhone = findViewById(R.id.txtPhone)
        txtDiaChi = findViewById(R.id.txtDiaChi)
        ImgThongTinKH = findViewById(R.id.ImgThongTinKH)
        txtTongTienSP = findViewById(R.id.txtSoTienSanPham)
        txtTongTienVanChuyen = findViewById(R.id.txtTongTienVanChuyen)
        txtTongTien = findViewById(R.id.txtTongTien)
        txtTongThanhToan = findViewById(R.id.txtTongThanhToan)
        txtPhuongThucThanhToan = findViewById(R.id.txtPhuongThucThanhToan)
        baohiemthoitrang = findViewById(R.id.baohiemthoitrang)
        btnHang = findViewById(R.id.btnHang)
        btnQuayLai = findViewById(R.id.btnQuayLai)

        // Nhận dữ liệu từ Activity ThongTinNhanHang
        val customerName = intent.getStringExtra("customer_name")
        val customerPhone = intent.getStringExtra("customer_phone")
        val customerAddress = intent.getStringExtra("customer_address")
        finalTotal = intent.getIntExtra("total_price", 0)

        // Cập nhật thông tin khách hàng
        if (customerName != null || customerPhone != null || customerAddress != null) {
            txtTenKH.text = customerName ?: "N/A"
            txtPhone.text = customerPhone ?: "N/A"
            txtDiaChi.text = customerAddress ?: "N/A"
        }

        // Cập nhật giá trị tổng ban đầu
        val initialTotal = finalTotal + shippingPrice

        // Cập nhật txtTongThanhToan lần đầu tiên
        txtTongThanhToan.text = formatCurrency(initialTotal)

        // Xử lý sự kiện thay đổi checkbox bảo hiểm
        baohiemthoitrang.setOnCheckedChangeListener { _, isChecked ->
            updatePriceWithInsurance(isChecked)
        }

        // Xử lý sự kiện nhấn nút "Đặt hàng"
        btnHang.setOnClickListener {
            val totalPayment = txtTongThanhToan.text.toString().replace("đ", "").replace(",", "").toInt()

            // Tạo Intent để chuyển sang ThongTinDonHang
            val intent = Intent(this, ThongTinDonHang::class.java)
            intent.putExtra("total_payment", totalPayment)  // Truyền giá trị tổng tiền qua Intent
            startActivity(intent)

        }

        // Xử lý sự kiện nhấn nút "Quay lại"
        btnQuayLai.setOnClickListener {
            finish() // Quay lại Activity trước
        }

        // Xử lý sự kiện nhấn vào ảnh thông tin khách hàng
        ImgThongTinKH.setOnClickListener {
            val intent = Intent(this, ThongTinNhanHang::class.java)
            intent.putExtra("customer_name", txtTenKH.text.toString())
            intent.putExtra("customer_phone", txtPhone.text.toString())
            intent.putExtra("customer_address", txtDiaChi.text.toString())
            startActivity(intent)
        }

        // Xử lý sự kiện nhấn vào phương thức thanh toán
        txtPhuongThucThanhToan.setOnClickListener {
            // Mở Activity chọn phương thức thanh toán
            val intent = Intent(this, PhuongThucThanhToan::class.java)
            startActivityForResult(intent, PAYMENT_METHOD_REQUEST_CODE) // Mở Activity chọn phương thức thanh toán
        }
    }

    // Nhận kết quả từ Activity PhuongThucThanhToan
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PAYMENT_METHOD_REQUEST_CODE && resultCode == RESULT_OK) {
            // Nhận phương thức thanh toán từ Activity PhuongThucThanhToan
            val selectedPaymentMethod = data?.getStringExtra("selected_payment_method")
            txtPhuongThucThanhToan.text = selectedPaymentMethod ?: "Chưa chọn phương thức"
        }
    }

    private fun updatePriceWithInsurance(isChecked: Boolean) {
        val initialTotal = finalTotal + shippingPrice
        val totalWithInsurance = if (isChecked) {
            initialTotal + insurancePrice
        } else {
            initialTotal
        }
        txtTongThanhToan.text = formatCurrency(totalWithInsurance)
    }

    // Tính tổng tiền thanh toán
    private fun calculateTotalPrice(): Int {
        val insurancePrice = if (baohiemthoitrang.isChecked) 300 else 0
        return finalTotal + shippingPrice + additionalFee + insurancePrice
    }

    // Định dạng tiền tệ
    private fun formatCurrency(amount: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        return "${decimalFormat.format(amount)}đ"
    }
}
