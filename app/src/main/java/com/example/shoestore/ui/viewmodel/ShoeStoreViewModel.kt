package com.example.shoestore.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.Shoe

class ShoeStoreViewModel : ViewModel() {
    private val _mutableShoeList = mutableListOf<Shoe>()

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _mutableShoeList.clear()
    }

    fun addShoe(newShoe: Shoe) {
        _mutableShoeList.add(newShoe)
        _shoeList.value = _mutableShoeList
    }
}