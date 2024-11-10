package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SuaSpActivity : AppCompatActivity() {

    lateinit var toolbarSuaSp: Toolbar
    lateinit var edtProductName: EditText
    lateinit var edtProductPrice: EditText
    lateinit var edtProductDescription: EditText
    lateinit var textViewImagePath: TextView
    lateinit var btnChooseImage: Button
    lateinit var btnUpdateProduct: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.suasanpham)

        // Gọi hàm setControl() để khởi tạo các phần tử giao diện
        setControl()

        // Gọi hàm setEvent() để xử lý các sự kiện
        setEvent()
    }

    // Hàm khởi tạo các phần tử giao diện
    private fun setControl() {
        toolbarSuaSp = findViewById(R.id.toolbarSuaSp)
        edtProductName = findViewById(R.id.edtProductName)
        edtProductPrice = findViewById(R.id.edtProductPrice)
        edtProductDescription = findViewById(R.id.edtProductDescription)
        textViewImagePath = findViewById(R.id.textViewImagePath)
        btnChooseImage = findViewById(R.id.buttonChooseImage)
        btnUpdateProduct = findViewById(R.id.btnUpdateProduct)

        // Hiển thị toolbar
        setSupportActionBar(toolbarSuaSp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    // Hàm xử lý các sự kiện của các phần tử giao diện
    private fun setEvent() {
        // Lấy dữ liệu từ Intent nếu có
        val tenSanPham = intent.getStringExtra("TEN_SAN_PHAM")
        val giaSanPham = intent.getStringExtra("GIA_SAN_PHAM")
        val moTaSanPham = intent.getStringExtra("MO_TA_SAN_PHAM")
        val imagePath = intent.getStringExtra("IMAGE_PATH")

        // Điền thông tin vào các EditText và TextView
        edtProductName.setText(tenSanPham)
        edtProductPrice.setText(giaSanPham)
        edtProductDescription.setText(moTaSanPham)
        textViewImagePath.text = "Đường dẫn ảnh: $imagePath" // Hiển thị đường dẫn ảnh

        // Cập nhật thông tin khi nhấn nút "Cập nhật sản phẩm"
        btnUpdateProduct.setOnClickListener {
            val tenMoi = edtProductName.text.toString()
            val giaMoi = edtProductPrice.text.toString()
            val moTaMoi = edtProductDescription.text.toString()

            // Ở đây bạn có thể cập nhật thông tin vào cơ sở dữ liệu hoặc server
            // Ví dụ: gọi API hoặc lưu vào database

            // Thông báo đã cập nhật thành công
            finish() // Hoặc chuyển lại màn hình quản lý sản phẩm
        }

        // Xử lý sự kiện chọn ảnh nếu cần
        btnChooseImage.setOnClickListener {
            // Xử lý chọn ảnh từ thư viện hoặc lưu trữ
            // Ví dụ: mở Activity chọn ảnh và cập nhật lại đường dẫn ảnh vào TextView
        }
    }

    // Xử lý sự kiện khi nhấn nút Back
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {  // Nút Back trên Toolbar
                finish()  // Quay lại màn hình trước
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
