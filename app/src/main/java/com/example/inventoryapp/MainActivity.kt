//fragment credit: https://www.youtube.com/watch?v=Y8mGxxRe3k4&t=410s

package com.example.inventoryapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    //late initialise variable
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView

    //late initialise fragment
    lateinit var homepageFragment: HomepageFragment
    lateinit var inventoryFragment: InventoryFragment
    lateinit var historyFragment: HistoryFragment
    lateinit var updateInventoryFragment: UpdateInventoryFragment
    lateinit var stockCheckingFragment: StockCheckingFragment
    lateinit var stockUsageFragment: StockUsageFragment

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

        homepageFragment = HomepageFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,homepageFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Inventory ->{
                //Toast.makeText(applicationContext,"Inventory is Clicked",Toast.LENGTH_SHORT).show()
                inventoryFragment = InventoryFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, inventoryFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }

            R.id.UpdateInventory ->{
                //Toast.makeText(applicationContext,"Update Inventory is Clicked",Toast.LENGTH_SHORT).show()
                updateInventoryFragment = UpdateInventoryFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, updateInventoryFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }

            R.id.StockChecking ->{
                //Toast.makeText(applicationContext,"Stock Checking is Clicked",Toast.LENGTH_SHORT).show()
                stockCheckingFragment = StockCheckingFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,stockCheckingFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }

            R.id.StockUsage -> {
                //Toast.makeText(applicationContext,"Stock Usage is Clicked",Toast.LENGTH_SHORT).show()
                stockUsageFragment = StockUsageFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,stockUsageFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }

            R.id.History ->{
                //Toast.makeText(applicationContext,"History is Clicked",Toast.LENGTH_SHORT).show()
                historyFragment = HistoryFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,historyFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }
}