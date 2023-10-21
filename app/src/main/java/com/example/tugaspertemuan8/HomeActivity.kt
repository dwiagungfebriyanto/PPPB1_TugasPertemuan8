package com.example.tugaspertemuan8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // custom action bar
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setCustomView(R.layout.action_bar)

        setContentView(R.layout.activity_home)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                // logout
                val intentToAuthenticationActivity = Intent(this@HomeActivity, AuthenticationActivity::class.java)
                Toast.makeText(this@HomeActivity, "See you soon!", Toast.LENGTH_SHORT).show()
                startActivity(intentToAuthenticationActivity)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}