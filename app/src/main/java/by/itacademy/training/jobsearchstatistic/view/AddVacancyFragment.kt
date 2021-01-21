package by.itacademy.training.jobsearchstatistic.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import by.itacademy.training.jobsearchstatistic.databinding.FragmentAddVacancyBinding
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyResource
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyStatus

class AddVacancyFragment : Fragment() {

    private lateinit var binding: FragmentAddVacancyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddVacancyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpSourceSpinner()
        setUpStatusSpinner()
    }

    private fun setUpSourceSpinner() {
        binding.vacancySourceSpinner.adapter =
            ArrayAdapter(
                activity as MainActivity,
                android.R.layout.simple_spinner_item,
                VacancyResource.values()
            )
    }

    private fun setUpStatusSpinner() {
        binding.statusSpinner.adapter =
            ArrayAdapter(
                activity as MainActivity,
                android.R.layout.simple_spinner_item,
                VacancyStatus.values()
            )
    }
}
