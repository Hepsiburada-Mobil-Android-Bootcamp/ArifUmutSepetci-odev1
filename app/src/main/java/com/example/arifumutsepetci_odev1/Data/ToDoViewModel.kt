package com.example.arifumutsepetci_odev1.Data

import androidx.lifecycle.ViewModel

class ToDoViewModel(private val toDoRepository: ToDoRepository):ViewModel() {
    fun getToDo() = toDoRepository.getToDo()

    fun addToDo(todo:ToDo) = toDoRepository.addToDo(todo)
}