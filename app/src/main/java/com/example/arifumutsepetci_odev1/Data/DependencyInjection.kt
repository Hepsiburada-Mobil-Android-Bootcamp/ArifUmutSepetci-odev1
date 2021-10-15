package com.example.arifumutsepetci_odev1.Data

object DependencyInjection {
    fun provideToDoViewModelFactory(): ToDoViewModelFactory{
        val toDoRepository = ToDoRepository.getInstance(ToDoDAO.getInstance().toDoTable)
        return ToDoViewModelFactory(toDoRepository)
    }
}