package com.example.myapplication

// Data class đại diện cho một sản phẩm trong giỏ hàng
data class Product(
    val name: String,    // Tên sản phẩm
    val price: Int,      // Giá của sản phẩm
    var quantity: Int    // Số lượng của sản phẩm trong giỏ
)
