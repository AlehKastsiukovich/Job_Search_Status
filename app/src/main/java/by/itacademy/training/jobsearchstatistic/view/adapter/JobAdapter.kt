package by.itacademy.training.jobsearchstatistic.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.training.jobsearchstatistic.domain.Vacancy

class JobAdapter : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    private val jobList = mutableListOf<Vacancy>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class JobViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView)
}
