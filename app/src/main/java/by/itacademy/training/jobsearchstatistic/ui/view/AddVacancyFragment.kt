package by.itacademy.training.jobsearchstatistic.ui.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.itacademy.training.jobsearchstatistic.R
import by.itacademy.training.jobsearchstatistic.constants.ARGUMENT_VACANCY_ID
import by.itacademy.training.jobsearchstatistic.constants.UPDATE_TEXT
import by.itacademy.training.jobsearchstatistic.databinding.FragmentAddVacancyBinding
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyResource
import by.itacademy.training.jobsearchstatistic.model.dto.VacancyStatus
import by.itacademy.training.jobsearchstatistic.util.Status
import by.itacademy.training.jobsearchstatistic.ui.viewmodel.CustomViewModelFactory
import by.itacademy.training.jobsearchstatistic.ui.viewmodel.VacanciesViewModel
import java.text.SimpleDateFormat
import java.util.Date

class AddVacancyFragment : Fragment() {

    private lateinit var binding: FragmentAddVacancyBinding
    private lateinit var sourceSpinner: Spinner
    private lateinit var statusSpinner: Spinner
    private lateinit var model: VacanciesViewModel
    private lateinit var factory: CustomViewModelFactory
    private lateinit var sourceSpinnerAdapter: ArrayAdapter<VacancyResource>
    private lateinit var statusSpinnerAdapter: ArrayAdapter<VacancyStatus>
    private var tempId: Int? = null

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
        viewVacancyData()
    }

    private fun setUpSourceSpinner() {
        sourceSpinnerAdapter = ArrayAdapter(
            activity as MainActivity,
            android.R.layout.simple_spinner_item,
            VacancyResource.values()
        )
        sourceSpinner = binding.vacancySourceSpinner.apply {
            adapter = sourceSpinnerAdapter
        }
    }

    private fun setUpStatusSpinner() {
        statusSpinnerAdapter = ArrayAdapter(
            activity as MainActivity,
            android.R.layout.simple_spinner_item,
            VacancyStatus.values()
        )
        statusSpinner = binding.statusSpinner.apply {
            adapter = statusSpinnerAdapter
        }
    }

    private fun setUpAddVacancyButton() {
        binding.addVacancyButton.setOnClickListener {
            val vacancy = createVacancy()
            preferUpdatingVacancy(vacancy)
            it.findNavController().navigate(R.id.action_addVacancyFragment_to_allJobsFragment, null)
        }
    }

    private fun preferUpdatingVacancy(vacancy: Vacancy) {
        if (binding.addVacancyButton.text == UPDATE_TEXT) {
            model.updateVacancy(vacancy)
        } else {
            model.addVacancy(vacancy)
        }
    }

    private fun viewVacancyData() {
        val vacancyId = arguments?.getInt(ARGUMENT_VACANCY_ID)
        vacancyId?.let { id ->
            tempId = id
            changeButtonTextToUpdate()
            model.getVacancyById(id)
            renderVacancy()
        }
    }

    private fun renderVacancy() {
        model.vacancy.observe(
            viewLifecycleOwner,
            { event ->
                when (event.status) {
                    Status.SUCCESS -> { event.data?.let { showVacancyFields(it) } }
                    Status.ERROR -> { }
                    Status.LOADING -> { }
                }
            }
        )
    }

    private fun changeButtonTextToUpdate() {
        binding.addVacancyButton.text = UPDATE_TEXT
    }

    private fun showVacancyFields(vacancy: Vacancy) {
        binding.companyTextView.setText(vacancy.company)
        binding.sourcePersonTextView.setText(vacancy.sourcePerson)
        val srcPosition = sourceSpinnerAdapter.getPosition(VacancyResource.valueOf(vacancy.source))
        val statusPosition = statusSpinnerAdapter.getPosition(VacancyStatus.valueOf(vacancy.status))
        sourceSpinner.setSelection(srcPosition)
        statusSpinner.setSelection(statusPosition)
    }

    private fun initViewModel() {
        model = ViewModelProvider(requireActivity(), factory).get(VacanciesViewModel::class.java)
    }

    private fun createVacancy(): Vacancy {
        val company = binding.companyTextView.text.toString()
        val recruiterName = binding.sourcePersonTextView.text.toString()
        val source = sourceSpinner.selectedItem.toString()
        val status = statusSpinner.selectedItem.toString()
        val date = SimpleDateFormat("dd-MM-yyyy").format(Date())
        return Vacancy(tempId ?: 0, date, company, source, recruiterName, status)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        factory = (context as MainActivity).viewModelFactory
    }
}
