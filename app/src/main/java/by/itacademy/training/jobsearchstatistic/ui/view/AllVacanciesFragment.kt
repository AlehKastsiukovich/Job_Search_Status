package by.itacademy.training.jobsearchstatistic.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import by.itacademy.training.jobsearchstatistic.R
import by.itacademy.training.jobsearchstatistic.constants.ARGUMENT_VACANCY_ID
import by.itacademy.training.jobsearchstatistic.databinding.FragmenAllJobsBinding
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.ui.adapter.OnVacancyClickListener
import by.itacademy.training.jobsearchstatistic.ui.adapter.VacancyAdapter
import by.itacademy.training.jobsearchstatistic.ui.viewmodel.VacanciesViewModel
import by.itacademy.training.jobsearchstatistic.util.Status
import org.koin.android.scope.ScopeFragment
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AllVacanciesFragment : ScopeFragment(), OnVacancyClickListener {

    private val model: VacanciesViewModel by viewModel()
    private val vacanciesAdapter: VacancyAdapter by inject { parametersOf(this) }

    private lateinit var binding: FragmenAllJobsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.apply {
            adapter = vacanciesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        renderData()
        setUpAddButton()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmenAllJobsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onVacancyClick(vacancy: Vacancy) {
        val bundle = Bundle()
        bundle.putInt(ARGUMENT_VACANCY_ID, vacancy.id)
        Navigation.findNavController(
            requireActivity(), R.id.myNavHostFragment
        ).navigate(R.id.action_allJobsFragment_to_addVacancyFragment, bundle)
    }

    private fun renderData() {
        model.vacanciesLiveData.observe(
            viewLifecycleOwner,
            { event ->
                when (event.status) {
                    Status.LOADING -> { }
                    Status.ERROR -> { }
                    Status.SUCCESS -> event.data?.let { vacanciesAdapter.update(it) }
                }
            }
        )
    }

    private fun setUpAddButton() {
        binding.addVacancyButton
            .setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.addVacancyFragment, null)
            )
    }
}
