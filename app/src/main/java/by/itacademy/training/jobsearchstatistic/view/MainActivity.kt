package by.itacademy.training.jobsearchstatistic.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import by.itacademy.training.jobsearchstatistic.R
import by.itacademy.training.jobsearchstatistic.view.viewmodel.CustomViewModelFactory

class MainActivity : AppCompatActivity() {

    val viewModelFactory = CustomViewModelFactory(this)
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
