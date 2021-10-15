package com.example.arifumutsepetci_odev1.Data

class ToDoDAO private constructor(){
    var toDoTable = ToDoTable()
        private set
    companion object{
        @Volatile private var instance: ToDoDAO? = null

        fun getInstance() =
            instance?: synchronized(this){
                instance?:ToDoDAO().also { instance=it }
            }
    }
}