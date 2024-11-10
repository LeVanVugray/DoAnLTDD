package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
//import com.example.project.R

class ThemSpActivity : AppCompatActivity() {
    lateinit var toolbarThemSp: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.themsanpham)  // Giao diện thêm sản phẩm

        // Khởi tạo toolbar
        toolbarThemSp = findViewById(R.id.toolbarThemSp)
        setSupportActionBar(toolbarThemSp)

        // Hiển thị nút Back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    // Xử lý sự kiện khi nhấn vào nút Back
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
