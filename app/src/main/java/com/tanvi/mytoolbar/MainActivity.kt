package com.tanvi.mytoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView // navview hai naki view
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
// dekho bs itna sa code s side naigation menu banti hai. ..yad mt kro, next time github s uthana h
    // uske phle github pr dalo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.mainDrawer)

        // y line side menu ko open/close hone ki capability deti hai
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        // yha is toggle ko drawer m set kiya hai
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        // is line se hambuger icon dikhne lagta hai
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarDrawerToggle.syncState()
        navView = findViewById(R.id.navView)

        // setNavigationItemSelectedListener y items k click pr kam krta hai
        // ekho hamburger click kam nhi krra h uske liye dekho
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.people -> {
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navView)
        return true
    }

    override fun onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
//phle smjo