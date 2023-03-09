package com.fahad.spacelaunch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.fahad.spacelaunch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Single activity which contains a navigation controller to direct to different presentation modules.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navHostFragment: NavHostFragment?
    get() = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? NavHostFragment

    private val navController: NavController?
    get() = navHostFragment?.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setupNavController()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController?.navigateUp() == true || super.onSupportNavigateUp()
    }

    private fun setupNavController() {
        navController?.let { setupActionBarWithNavController(it) }
    }
}