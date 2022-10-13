package com.example.practive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.practive.databinding.ActivityMainBinding
import com.example.practive.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragmentManager = supportFragmentManager
    private lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. viewBinding 해서 MainActivity 랑 activity_main 연결
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. 처음 보여질 Fragment 설정하기
        transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, HomeFragment())
        transaction.commit()

        // 3. ToolBar Setting & Change ToolBar Title
        setSupportActionBar(binding.toolBar)
        supportActionBar?.apply {
            title = "Tasks"
            setVisible(true)
        }
    }

    // ToolBar menu selector
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miSetting -> Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show()
        }
        return true
    }

    // ToolBar Menu Create
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
