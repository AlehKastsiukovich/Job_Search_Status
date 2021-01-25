package by.itacademy.training.jobsearchstatistic.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import by.itacademy.training.jobsearchstatistic.R
import by.itacademy.training.jobsearchstatistic.databinding.FragmenAllJobsBinding
import by.itacademy.training.jobsearchstatistic.domain.Vacancy
import by.itacademy.training.jobsearchstatistic.util.Status
import by.itacademy.training.jobsearchstatistic.view.adapter.OnVacancyClickListener
import by.itacademy.training.jobsearchstatistic.view.adapter.VacancyAdapter
import by.itacademy.training.jobsearchstatistic.view.viewmodel.CustomViewModelFactory
import by.itacademy.training.jobsearchstatistic.view.viewmodel.VacanciesViewModel

class AllVacanciesFragment : Fragment(), OnVacancyClickListener {

    private lateinit var binding: FragmenAllJobsBinding
    private lateinit var model: VacanciesViewModel
    private lateinit var factory: CustomViewModelFactory
    private lateinit var vacanciesAdapter: VacancyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        vacanciesAdapter = VacancyAdapter(this)
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
        TODO("Not yet implemented")
    }

    private fun renderData() {
        model.vacanciesLiveData.observe(
            viewLifecycleOwner,
            {
                when (it.status) {
                    Status.LOADING -> { }
                    Status.ERROR -> { }
                    Status.SUCCESS -> it.data?.let { vacanciesAdapter.update(it) }
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

    private fun initViewModel() {
        model = ViewModelProvider(viewModelStore, factory).get(VacanciesViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        factory = (context as MainActivity).viewModelFactory
    }
}
