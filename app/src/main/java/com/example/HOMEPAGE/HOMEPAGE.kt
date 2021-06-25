package com.example.HOMEPAGE

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.fstsignin.FOOD.FoodFragment
import com.example.MAPS.Map_location
import com.example.fstsignin.R
import com.example.fstsignin.SHOP.ShopFragment
import com.example.fstsignin.Start_Pages.FSTRegisterPage
import com.example.fstsignin.TRAVEL.TravelFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class HOMEPAGE : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        supportActionBar?.hide()




        var navigationView = findViewById<NavigationView>(R.id.nav_menu)

        navigationView.setNavigationItemSelectedListener(this)

        var toolbar =  findViewById<Toolbar>(R.id.toolbar)

        var drawerlayout=findViewById<DrawerLayout>(R.id.drawerlayout)
        setSupportActionBar(toolbar)
        val togglebar = ActionBarDrawerToggle(this, drawerlayout,toolbar,
            R.string.open,
            R.string.close
        )
        togglebar.isDrawerIndicatorEnabled=true
        drawerlayout.addDrawerListener(togglebar)
        togglebar.syncState()



        val viewpager : ViewPager = findViewById(R.id.viewPager)


        val locationn : ImageView = findViewById(R.id.locationn)
        locationn.setOnClickListener{
            intent = Intent(this, Map_location::class.java)
            startActivity(intent)
        }



        // val viewpager : FrameLayout = findViewById(R.id.viewPager)
        val tab : TabLayout = findViewById(R.id.tab)


        setupViewPager(viewpager)
        tab.setupWithViewPager(viewpager)


    }

    private fun setupViewPager(viewpager: ViewPager) {
        var adapter = ViewPagerAdapter(supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        adapter.addFragment(FoodFragment(this), "Food")
        adapter.addFragment(ShopFragment(this), "Shop")
        adapter.addFragment(TravelFragment(this), "Travel")



        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }


    class ViewPagerAdapter : FragmentPagerAdapter {


        private final var fraglist : ArrayList<Fragment> = ArrayList()
        private final var fragtitle: ArrayList<String> = ArrayList()

        // this is a secondary constructor of ViewPagerAdapter class.
        constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        // returns which item is selected from arraylist of fragments.
        override fun getItem(position: Int): Fragment {
            return fraglist.get(position)
        }

        // returns which item is selected from arraylist of titles.

        override fun getPageTitle(position: Int): CharSequence {
            return fragtitle.get(position)
        }

        // returns the number of items present in arraylist.
        override fun getCount(): Int {
            return fraglist.size
        }

        // this function adds the fragment and title in 2 separate  arraylist.
        fun addFragment(fragment: Fragment, title: String) {
            fraglist.add(fragment)
            fragtitle.add(title)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var id = item.itemId
        when(id)
        {
            R.id.home -> {
                Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
            }

            R.id.about -> {
                Toast.makeText(this, "About Clicked", Toast.LENGTH_SHORT).show()
            }

            R.id.contact -> {
                Toast.makeText(this, "contact Clicked", Toast.LENGTH_SHORT).show()
            }

            R.id.setting -> {
                Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show()
            }

             R.id.logout -> {
                var intent = Intent(this, FSTRegisterPage::class.java)
                 startActivity(intent)
            }



        }

        return true
    }
}
