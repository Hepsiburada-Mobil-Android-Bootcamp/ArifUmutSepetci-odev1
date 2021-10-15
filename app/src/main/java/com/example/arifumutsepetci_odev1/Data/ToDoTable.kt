package com.example.arifumutsepetci_odev1.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ToDoTable {
    private val toDoList = mutableListOf<ToDo>()
    private val liveToDo = MutableLiveData<List<ToDo>>()
    init {
        liveToDo.value = toDoList
    }
    fun addToDo(todo:ToDo){
        toDoList.add(todo)
        liveToDo.value = toDoList
    }
    fun getToDos() = liveToDo as LiveData<List<ToDo>>
}