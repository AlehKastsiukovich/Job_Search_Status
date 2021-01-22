package by.itacademy.training.jobsearchstatistic.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.itacademy.training.jobsearchstatistic.databinding.FragmentAddVacancyBinding
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyResource
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyStatus
import by.itacademy.training.jobsearchstatistic.view.viewmodel.CustomViewModelFactory
import by.itacademy.training.jobsearchstatistic.view.viewmodel.VacanciesViewModel
import java.text.SimpleDateFormat
import java.util.Date

class AddVacancyFragment : Fragment() {

    private lateinit var binding: FragmentAddVacancyBinding
    private lateinit var sourceSpinner: Spinner
    private lateinit var statusSpinner: Spinner
    private lateinit var model: VacanciesViewModel
    private lateinit var factory: CustomViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddVacancyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpSourceSpinner()
        setUpStatusSpinner()
        setUpAddVacancyButton()
        initViewModel()
    }

    private fun setUpSourceSpinner() {
        sourceSpinner = binding.vacancySourceSpinner.apply {
            adapter = ArrayAdapter(
                activity as MainActivity,
                android.R.layout.simple_spinner_item,
                VacancyResource.values()
            )
        }
    }

    private fun setUpStatusSpinner() {
        statusSpinner = binding.statusSpinner.apply {
            adapter = ArrayAdapter(
                activity as MainActivity,
                android.R.layout.simple_spinner_item,
                VacancyStatus.values()
            )
        }
    }

    private fun setUpAddVacancyButton() {
        binding.addVacancyButton.setOnClickListener {
            val vacancy = createVacancy()
            model.addVacancy(vacancy)
        }
    }

    private fun initViewModel() {
        model = ViewModelProvider(viewModelStore, factory).get(VacanciesViewModel::class.java)
    }

    private fun createVacancy(): Vacancy {
        val company = binding.companyTextView.text.toString()
        val recruiterName = binding.sourcePersonTextView.text.toString()
        val source = sourceSpinner.selectedItem.toString()
        val status = statusSpinner.selectedItem.toString()
        val date = SimpleDateFormat("dd-MM-yyyy").format(Date())
        return Vacancy(date, company, source, recruiterName, status)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        factory = (context as MainActivity).viewModelFactory
    }
}
