package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toolbarquanlysanpham: Toolbar
    lateinit var navigationview: NavigationView
    lateinit var listviewquanlysanpham: ListView
    lateinit var drawerlayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quanlysanpham)
        setControl()
        setEvent()
    }

    private fun setEvent() {
        setSupportActionBar(toolbarquanlysanpham)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarquanlysanpham.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size)
        toolbarquanlysanpham.setNavigationOnClickListener {
            drawerlayout.openDrawer(GravityCompat.START)
        }

        // Xử lý sự kiện khi người dùng chọn mục trong NavigationView
        navigationview.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_qlsp -> {
                    // Quản lý sản phẩm
                    true
                }
                R.id.menu_themsp -> {
                    // Chuyển sang màn hình thêm sản phẩm
                    val intent = Intent(this, ThemSpActivity::class.java)
                    startActivity(intent)
                    drawerlayout.closeDrawer(GravityCompat.START)  // Đóng menu sau khi chọn
                    true
                }
                R.id.menu_suasp -> {
                    // Chuyển sang màn hình sửa sản phẩm
                    val intent = Intent(this, SuaSpActivity::class.java)
                    startActivity(intent)
                    drawerlayout.closeDrawer(GravityCompat.START)  // Đóng menu sau khi chọn
                    true
                }
                R.id.menu_thoatsp -> {
                    // Thoát ứng dụng
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    private fun setControl() {
        toolbarquanlysanpham = findViewById(R.id.toolbarquanlysanpham)
        navigationview = findViewById(R.id.navigationview)
//        listviewquanlysanpham = findViewById(R.id.listviewquanlysanpham)
        drawerlayout = findViewById(R.id.drawerlayout)
    }

    // Xử lý sự kiện khi nhấn vào mục menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_qlsp -> {  // Mở màn hình quản lý sản phẩm
                true
            }
            R.id.menu_themsp -> {  // Mở màn hình thêm sản phẩm
                val intent = Intent(this, ThemSpActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_suasp -> {  // Mở màn hình sửa sản phẩm
                val intent = Intent(this, SuaSpActivity::class.java)
                // Truyền dữ liệu sản phẩm cần sửa (ví dụ từ ListView hoặc RecyclerView)
//                intent.putExtra("TEN_SAN_PHAM", "Tên sản phẩm")
//                intent.putExtra("GIA_SAN_PHAM", "100000")
                startActivity(intent)
                true
            }
            R.id.menu_thoatsp -> {  // Thoát ứng dụng
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
