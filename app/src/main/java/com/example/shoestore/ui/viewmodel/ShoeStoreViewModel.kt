package com.example.shoestore.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.Shoe
import com.example.shoestore.util.Event

class ShoeStoreViewModel : ViewModel() {
    private val _mutableShoeList = mutableListOf<Shoe>()

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _event = MutableLiveData<Event<Boolean>>()
    val event: LiveData<Event<Boolean>>
        get() = _event


    init {
        _mutableShoeList.clear()
    }

    fun addShoe(newShoe: Shoe) {
        _mutableShoeList.add(newShoe.copy())
        _shoeList.value = _mutableShoeList
        _event.value = Event(true)
    }
}