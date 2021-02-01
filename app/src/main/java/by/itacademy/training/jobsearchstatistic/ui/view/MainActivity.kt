package by.itacademy.training.jobsearchstatistic.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import by.itacademy.training.jobsearchstatistic.R

class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpButton()
    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp()
    }

    private fun setUpButton() {
        controller = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, controller)
    }
}
