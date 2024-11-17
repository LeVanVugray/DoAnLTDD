package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Xoa : AppCompatActivity() {

    private lateinit var btnXoa: Button
    private lateinit var btnQuayLai: ImageView
    private lateinit var btnXong: TextView
    private lateinit var chonTatCa: CheckBox
    private lateinit var txtSoLuong1: TextView
    private lateinit var txtSoLuong2: TextView
    private lateinit var btnTru1: Button
    private lateinit var btnCong1: Button
    private lateinit var btnTru2: Button
    private lateinit var btnCong2: Button
    private lateinit var chonSP1: CheckBox
    private lateinit var chonSP2: CheckBox

    private var isChonTatCa: Boolean = false
    private var isChonSP1: Boolean = false
    private var isChonSP2: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sua) // Replace with your actual layout file

        // Initialize views
        btnXoa = findViewById(R.id.btnXoa)
        btnQuayLai = findViewById(R.id.QuayLai)
        btnXong = findViewById(R.id.txtXong)
        chonTatCa = findViewById(R.id.Chontatca)
        txtSoLuong1 = findViewById(R.id.txtSoLuong1)
        txtSoLuong2 = findViewById(R.id.txtSoLuong2)
        btnTru1 = findViewById(R.id.btnTru1)
        btnCong1 = findViewById(R.id.btnCong1)
        btnTru2 = findViewById(R.id.btnTru2)
        btnCong2 = findViewById(R.id.btnCong2)
        chonSP1 = findViewById(R.id.chonSP1)
        chonSP2 = findViewById(R.id.chonSP2)

        // Set up click listeners for navigation
        btnQuayLai.setOnClickListener { finish() }
        btnXong.setOnClickListener { finish() }

        // Handle "Chọn tất cả" checkbox
        chonTatCa.setOnCheckedChangeListener { _, isChecked ->
            isChonTatCa = isChecked
            chonSP1.isChecked = isChecked
            chonSP2.isChecked = isChecked
        }

        // Handle individual product checkboxes
        chonSP1.setOnCheckedChangeListener { _, isChecked -> isChonSP1 = isChecked }
        chonSP2.setOnCheckedChangeListener { _, isChecked -> isChonSP2 = isChecked }

        // Handle "Xóa" button click
        btnXoa.setOnClickListener {
            if (isChonTatCa) {
                // If "Chọn tất cả" is selected, clear quantities for both products
                txtSoLuong1.text = "0"
                txtSoLuong2.text = "0"
                Toast.makeText(this, "Đã xóa tất cả sản phẩm", Toast.LENGTH_SHORT).show()
            } else {
                val quantity1 = txtSoLuong1.text.toString().toInt()
                val quantity2 = txtSoLuong2.text.toString().toInt()

                // If Product 1 is selected and its quantity is greater than 0, delete it
                if (isChonSP1 && quantity1 > 0) {
                    txtSoLuong1.text = "0"
                    chonSP1.isChecked = false // Uncheck the checkbox
                    Toast.makeText(this, "Sản phẩm 1 đã được xóa", Toast.LENGTH_SHORT).show()
                }

                // If Product 2 is selected and its quantity is greater than 0, delete it
                if (isChonSP2 && quantity2 > 0) {
                    txtSoLuong2.text = "0"
                    chonSP2.isChecked = false // Uncheck the checkbox
                    Toast.makeText(this, "Sản phẩm 2 đã được xóa", Toast.LENGTH_SHORT).show()
                }

                // If no products were deleted, show a message
                if (quantity1 == 0 && quantity2 == 0) {
                    Toast.makeText(this, "Không có sản phẩm nào để xóa", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Handle quantity increment and decrement for Product 1
        btnCong1.setOnClickListener {
            val currentQty = txtSoLuong1.text.toString().toInt()
            txtSoLuong1.text = (currentQty + 1).toString()
        }

        btnTru1.setOnClickListener {
            val currentQty = txtSoLuong1.text.toString().toInt()
            if (currentQty > 0) {
                txtSoLuong1.text = (currentQty - 1).toString()
            }
        }

        // Handle quantity increment and decrement for Product 2
        btnCong2.setOnClickListener {
            val currentQty = txtSoLuong2.text.toString().toInt()
            txtSoLuong2.text = (currentQty + 1).toString()
        }

        btnTru2.setOnClickListener {
            val currentQty = txtSoLuong2.text.toString().toInt()
            if (currentQty > 0) {
                txtSoLuong2.text = (currentQty - 1).toString()
            }
        }
    }
}
