package com.example.inventoryapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    //late initialise variable
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This method sets the toolbar as the app bar for the activity
        setSupportActionBar(findViewById(R.id.toolbar))

        drawerLayout = findViewById(R.id.DrawerLayout)
        navigationView = findViewById(R.id.NavigationView)

        val Toggle = ActionBarDrawerToggle(
            //this,drawerLayout,toolbar,0,0
            this,drawerLayout,0,0
        )

        drawerLayout.addDrawerListener(Toggle)
        Toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Inventory ->{
                Toast.makeText(applicationContext,"Inventory is Clicked",Toast.LENGTH_SHORT).show()
            }

            R.id.UpdateInventory ->{
                Toast.makeText(applicationContext,"Update Inventory is Clicked",Toast.LENGTH_SHORT).show()
            }

            R.id.StockChecking ->{
                Toast.makeText(applicationContext,"Stock Checking is Clicked",Toast.LENGTH_SHORT).show()
            }

            R.id.StockUsage -> {
                Toast.makeText(applicationContext,"Stock Usage is Clicked",Toast.LENGTH_SHORT).show()
            }

            R.id.History ->{
                Toast.makeText(applicationContext,"History is Clicked",Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}