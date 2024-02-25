package com.sdcproject.notesmcet

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.sdcproject.notesmcet.MainActivity2
import com.sdcproject.notesmcet.databinding.NavActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var drawerLayout: DrawerLayout
    lateinit var binding: NavActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=NavActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        drawerLayout =findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.open, R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView : NavigationView=findViewById(R.id.nav_view)

        // Handle item clicks in the navigation drawer
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle item 1 click by starting an activity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_search -> {
                    // Handle item 2 click by starting a different activity
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                }
                // Add more items as needed
            }
            drawerLayout.closeDrawers()
            true
        }



        val secondActButton= findViewById<ImageButton>(R.id.imageButton8)
        secondActButton.setOnClickListener {
            val Intent = Intent(this, MainActivity2::class.java)
            startActivity(Intent)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

}