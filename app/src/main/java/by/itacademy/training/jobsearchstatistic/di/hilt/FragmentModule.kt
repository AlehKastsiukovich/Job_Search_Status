package by.itacademy.training.jobsearchstatistic.di.hilt

import androidx.fragment.app.Fragment
import by.itacademy.training.jobsearchstatistic.ui.adapter.OnVacancyClickListener
import by.itacademy.training.jobsearchstatistic.ui.adapter.VacancyAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    @FragmentScoped
    fun provideOnVacancyClickListener(fragment: Fragment) = fragment as OnVacancyClickListener

    @Provides
    @FragmentScoped
    fun provideAdapter(onVacancyClickListener: OnVacancyClickListener) =
        VacancyAdapter(onVacancyClickListener)
}
