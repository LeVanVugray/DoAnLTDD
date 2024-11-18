package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class TrangChuGioHang : AppCompatActivity() {

    // Danh sách các sản phẩm trong giỏ hàng
    private val products = mutableListOf(
        Product("Áo Thun Basic", 350000, 1),
        Product("Áo Len Dày", 200000, 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.giohang)

        // Lấy các Views
        val txtSoLuong1 = findViewById<TextView>(R.id.txtSoLuong1)
        val txtSoLuong2 = findViewById<TextView>(R.id.txtSoLuong2)
        val btnCong1 = findViewById<Button>(R.id.btnCong1)
        val btnTru1 = findViewById<Button>(R.id.btnTru1)
        val btnCong2 = findViewById<Button>(R.id.btnCong2)
        val btnTru2 = findViewById<Button>(R.id.btnTru2)
        val rdbtn1 = findViewById<RadioButton>(R.id.rdbtn1)
        val rdbtn2 = findViewById<RadioButton>(R.id.rdbtn2)
        val txtTongTien = findViewById<TextView>(R.id.txtTongGiaTien)
        val btnThanhToan = findViewById<Button>(R.id.btnDatHang) // Button thanh toán
        val txtSua = findViewById<TextView>(R.id.txtSua)
        val imgChat = findViewById<ImageView>(R.id.ImgChat) // ImageView cho chat

        // Hiển thị số lượng ban đầu
        txtSoLuong1.text = products[0].quantity.toString()
        txtSoLuong2.text = products[1].quantity.toString()

        // Cập nhật tổng tiền ban đầu
        updateTotal(txtTongTien)

        // Sự kiện nút cộng và trừ cho sản phẩm 1
        btnCong1.setOnClickListener {
            products[0].quantity++
            txtSoLuong1.text = products[0].quantity.toString()
            updateTotal(txtTongTien)  // Cập nhật tổng tiền
        }

        btnTru1.setOnClickListener {
            if (products[0].quantity > 1) {
                products[0].quantity--
                txtSoLuong1.text = products[0].quantity.toString()
                updateTotal(txtTongTien)
            }
        }

        // Sự kiện nút cộng và trừ cho sản phẩm 2
        btnCong2.setOnClickListener {
            products[1].quantity++
            txtSoLuong2.text = products[1].quantity.toString()
            updateTotal(txtTongTien)
        }

        btnTru2.setOnClickListener {
            if (products[1].quantity > 1) {
                products[1].quantity--
                txtSoLuong2.text = products[1].quantity.toString()
                updateTotal(txtTongTien)
            }
        }

        // Thêm sự kiện cho RadioButton để cập nhật khi người dùng chọn sản phẩm
        rdbtn1.setOnCheckedChangeListener { _, _ -> updateTotal(txtTongTien) }
        rdbtn2.setOnCheckedChangeListener { _, _ -> updateTotal(txtTongTien) }

        // Sự kiện nhấn nút Thanh Toán
        btnThanhToan.setOnClickListener {
            val totalPrice = getTotalPrice()

            // Chuyển tổng tiền qua màn hình ThanhToan
            val intent = Intent(this, ThanhToan::class.java)
            intent.putExtra("total_price", totalPrice)
            startActivity(intent)
        }

        // Sự kiện nhấn nút sửa
        txtSua.setOnClickListener {
            val intent = Intent(this, Xoa::class.java)
            startActivity(intent)
        }

        // Sự kiện nhấn vào ImgChat để chuyển sang màn hình chat
        imgChat.setOnClickListener {
            val intent = Intent(this, Chat::class.java)  // Mở màn hình ChatActivity
            startActivity(intent)
        }
    }

    // Tính tổng tiền giỏ hàng
    private fun getTotalPrice(): Int {
        var totalPrice = 0

        // Kiểm tra nếu sản phẩm 1 được chọn và tính giá
        if (findViewById<RadioButton>(R.id.rdbtn1).isChecked) {
            totalPrice += products[0].price * products[0].quantity
        }

        // Kiểm tra nếu sản phẩm 2 được chọn và tính giá
        if (findViewById<RadioButton>(R.id.rdbtn2).isChecked) {
            totalPrice += products[1].price * products[1].quantity
        }

        return totalPrice
    }

    // Cập nhật tổng tiền khi số lượng thay đổi và trạng thái của radio buttons
    private fun updateTotal(txtTongTien: TextView) {
        var totalPrice = 0

        // Kiểm tra nếu sản phẩm 1 được chọn thì tính giá
        if (findViewById<RadioButton>(R.id.rdbtn1).isChecked) {
            totalPrice += products[0].price * products[0].quantity
        }

        // Kiểm tra nếu sản phẩm 2 được chọn thì tính giá
        if (findViewById<RadioButton>(R.id.rdbtn2).isChecked) {
            totalPrice += products[1].price * products[1].quantity
        }

        // Nếu không có sản phẩm nào được chọn, giá hiển thị là 0
        if (!findViewById<RadioButton>(R.id.rdbtn1).isChecked && !findViewById<RadioButton>(R.id.rdbtn2).isChecked) {
            txtTongTien.text = "đ0"
        } else {
            txtTongTien.text = formatCurrency(totalPrice)
        }
    }

    // Hàm để định dạng tiền với dấu phẩy
    private fun formatCurrency(amount: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        return "đ${decimalFormat.format(amount)}"
    }
}
