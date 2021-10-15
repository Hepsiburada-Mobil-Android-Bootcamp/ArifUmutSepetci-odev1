package com.example.arifumutsepetci_odev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.arifumutsepetci_odev1.Data.DependencyInjection
import com.example.arifumutsepetci_odev1.Data.ToDo
import com.example.arifumutsepetci_odev1.Data.ToDoViewModel
import java.lang.StringBuilder

class ToDoActivity : AppCompatActivity() {
    val todotext by lazy { findViewById<EditText>(R.id.editText_to_do) }
    val topText by lazy { findViewById<TextView>(R.id.textView_to_dos) }
    val button by lazy { findViewById<Button>(R.id.button_add_to_do) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = DependencyInjection.provideToDoViewModelFactory()
        val viewModel = ViewModelProvider(this,factory).get(ToDoViewModel::class.java)
        viewModel.getToDo().observe(this, Observer {
                toDoList ->
            val stringBuilder = StringBuilder()
            toDoList.forEach { todo ->
                stringBuilder.append("$todo\n\n")
            }
            topText.text = stringBuilder.toString()
        })
        button.setOnClickListener{
            val todo = ToDo(todotext.text.toString())
            viewModel.addToDo(todo)
            todotext.setText("")
        }
    }
}