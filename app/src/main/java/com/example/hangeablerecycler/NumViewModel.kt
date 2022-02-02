package com.example.hangeablerecycler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.schedule
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

class NumViewModel : ViewModel() {
    var liveData = MutableLiveData<List<Int>>()
    val repository = Repository

    init{generateNewNum()}

    fun updateList() {
        liveData.postValue(repository.getList())
    }

    fun delNumandUpdate(num: Int) {
        repository.delNum(num)
        updateList()
    }

    fun generateNewNum(){
        val timer = Timer()

        timer.scheduleAtFixedRate(5000, 5000) {
            repository.addNum()
            updateList()
        }
    }

}