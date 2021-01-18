package by.itacademy.training.jobsearchstatistic.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.itacademy.training.jobsearchstatistic.databinding.FragmenAllJobsBinding

class AllJobsFragment : Fragment() {

    private lateinit var binding: FragmenAllJobsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmenAllJobsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
