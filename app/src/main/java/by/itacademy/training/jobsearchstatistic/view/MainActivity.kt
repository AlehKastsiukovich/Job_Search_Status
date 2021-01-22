package by.itacademy.training.jobsearchstatistic.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.itacademy.training.jobsearchstatistic.R
import by.itacademy.training.jobsearchstatistic.view.viewmodel.CustomViewModelFactory

class MainActivity : AppCompatActivity() {

    val viewModelFactory = CustomViewModelFactory(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
