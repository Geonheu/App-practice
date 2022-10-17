package com.example.practive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.practive.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragmentManager = supportFragmentManager
    private lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. viewBinding 설정
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. 처음 보여질 Fragment 설정하기
        transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, MineFragment())
        transaction.commit()

        // 3. Toolbar Setting & Change Toolbar Title
        setSupportActionBar(binding.toolBar)

    }

    // Toolbar 메뉴 선택했을 때 실행되는 함수
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.search -> Toast.makeText(this, "Search", Toast.LENGTH_LONG).show()
            R.id.notice -> Toast.makeText(this, "Notification", Toast.LENGTH_LONG).show()
            R.id.drawer -> Toast.makeText(this, "Menu", Toast.LENGTH_LONG).show()
        }
        return true
    }

    // Toolbar 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
