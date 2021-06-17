package com.azizapp.test.ui.map

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azizapp.test.model.TitikBanjir
import com.azizapp.test.model.TitikTersumbat
import com.azizapp.test.repository.MainRepository
import com.azizapp.test.utill.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    val listTitikBanjir: ArrayList<TitikBanjir> = arrayListOf()
    val listTitikTersumbat: ArrayList<TitikTersumbat> = arrayListOf()
    val action = MutableLiveData<String>()
    val actionItemPosition = MutableLiveData<Int>()

    fun onLoad() {
        viewModelScope.launch {
            when (val response = repository.getTitikBanjir()) {
                is Resource.Success -> {
                    response.data?.forEach {
                        listTitikBanjir.add(it)
                    }
                }
                is Resource.Error -> {
                }
            }

        }
    }

    fun titikTersumbat() {
        viewModelScope.launch {
            when (val response = repository.getTitikTersumbat()) {
                is Resource.Success -> {
                    response.data?.forEach {
                        listTitikTersumbat.add(it)
                    }
                }
                is Resource.Error -> {
                }
            }
        }
    }
}