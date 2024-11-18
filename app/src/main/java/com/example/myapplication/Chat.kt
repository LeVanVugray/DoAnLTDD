package com.example.myapplication

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Chat : AppCompatActivity() {
    private lateinit var btnQuayLai: ImageButton // Make it non-nullable using lateinit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat) // Layout của màn hình chat

        // Khởi tạo các view
        btnQuayLai = findViewById(R.id.btnQuayLai)

        // Xử lý sự kiện khi người dùng nhấn "Quay lại"
        btnQuayLai.setOnClickListener {
            // Quay lại Activity trước đó (giả sử là Giỏ hàng Activity)
            finish() // Kết thúc Activity hiện tại và quay lại màn hình trước đó
        }
    }
}
