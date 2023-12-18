package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.todoapp.R
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID
import com.google.android.material.textfield.TextInputEditText

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val btnDeleteTask = findViewById<Button>(R.id.btn_delete_task)
        val detailEdTitle = findViewById<TextInputEditText>(R.id.detail_ed_title)
        val detailEdDescription = findViewById<TextInputEditText>(R.id.detail_ed_description)
        val detailEdDueDate = findViewById<TextInputEditText>(R.id.detail_ed_due_date)

        val taskId = intent.getIntExtra(TASK_ID, 0)
        val factory = ViewModelFactory.getInstance(this)

        viewModel = ViewModelProvider(this, factory).get(DetailTaskViewModel::class.java)
        viewModel.setTaskId(taskId)
        viewModel.task.observe(this, { task ->
            if (task != null) {
                detailEdTitle.setText(task.title)
                detailEdDescription.setText(task.description)
                detailEdDueDate.setText(DateConverter.convertMillisToString(task.dueDateMillis))
            }
        })

        btnDeleteTask.setOnClickListener {
            viewModel.deleteTask()
            finish()
        }
    }
}