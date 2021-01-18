package by.itacademy.training.jobsearchstatistic.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.training.jobsearchstatistic.R
import by.itacademy.training.jobsearchstatistic.databinding.JobItemBinding
import by.itacademy.training.jobsearchstatistic.domain.Vacancy

class JobAdapter : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    private val vacancyList = mutableListOf<Vacancy>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.job_item, parent)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        holder.bind(vacancyList[position])
    }

    fun update(vacancies: List<Vacancy>) {
        vacancyList.clear()
        vacancyList.addAll(vacancies)
        notifyDataSetChanged()
    }

    override fun getItemCount() = vacancyList.size

    class JobViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: JobItemBinding = JobItemBinding.bind(itemView)

        fun bind(vacancy: Vacancy) {
            with(binding) {
                dateTextView.text = vacancy.date
                companyTextView.text = vacancy.company
                statusTextView.text = vacancy.status
                vacancySourceTextView.text = vacancy.source
                personalityTextView.text = vacancy.sourcePerson
            }
        }
    }
}
