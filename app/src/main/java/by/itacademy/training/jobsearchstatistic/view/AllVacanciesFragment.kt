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
import by.itacademy.training.jobsearchstatistic.model.db.VacanciesDatabase
import by.itacademy.training.jobsearchstatistic.model.repository.VacanciesRepositoryImpl
import by.itacademy.training.jobsearchstatistic.util.DtoMapperImpl
import by.itacademy.training.jobsearchstatistic.util.Status
import by.itacademy.training.jobsearchstatistic.view.adapter.VacancyAdapter
import by.itacademy.training.jobsearchstatistic.view.viewmodel.CustomViewModelFactory
import by.itacademy.training.jobsearchstatistic.view.viewmodel.VacanciesViewModel

class AllVacanciesFragment : Fragment() {

    private lateinit var binding: FragmenAllJobsBinding
    private lateinit var model: VacanciesViewModel
    private lateinit var database: VacanciesDatabase
    private lateinit var mainActivity: Context
    private lateinit var vacanciesAdapter: VacancyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initDao()
        initViewModel()
        vacanciesAdapter = VacancyAdapter()
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
        model = ViewModelProvider(
            viewModelStore,
            CustomViewModelFactory(
                VacanciesRepositoryImpl(database.vacanciesDao(), DtoMapperImpl())
            )
        ).get(VacanciesViewModel::class.java)
    }

    private fun initDao() {
        database = VacanciesDatabase.getDatabase(mainActivity.applicationContext)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = (context as MainActivity)
    }
}
