package com.example.arifumutsepetci_odev1.Data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ToDoViewModelFactory(private val toDoRepository: ToDoRepository):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel?>create(modelClass:Class<T>):T{
        return ToDoViewModel(toDoRepository) as T
    }

}