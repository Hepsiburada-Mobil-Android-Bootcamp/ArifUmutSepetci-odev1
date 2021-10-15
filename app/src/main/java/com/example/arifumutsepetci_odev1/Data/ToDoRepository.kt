package com.example.arifumutsepetci_odev1.Data

class ToDoRepository private constructor(private val tododao:ToDoTable) {
    fun addToDo(todo:ToDo){
        tododao.addToDo(todo)
    }
    fun getToDo() = tododao.getToDos()
    companion object{
        @Volatile private var instance: ToDoRepository?= null
        fun getInstance(tododao: ToDoTable)=
            instance?: synchronized(this){
                instance?:ToDoRepository(tododao).also { instance=it }
            }
    }
}