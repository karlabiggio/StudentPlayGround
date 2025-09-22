package edu.iesam.studentplayground.features.students.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.studentplayground.R
import edu.iesam.studentplayground.features.students.data.StudentDataRepository
import edu.iesam.studentplayground.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.data.local.StudentMemLocalDataSource
import edu.iesam.studentplayground.features.students.domain.FetchStudentsUseCase
import org.example.edu.iesam.students.data.local.StudentXmlLocalDataSource

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initStudents()
    }
        fun initStudents() {
            val xml = StudentXmlLocalDataSource()
            val mem = StudentMemLocalDataSource()
            val api = StudentApiRemoteDataSource()
            val dataRepository = StudentDataRepository(xml, mem, api)
            val fetch = FetchStudentsUseCase(dataRepository)
            val useCase = SaveStudentUseCase(dataRepository)

            val viewModel = StudentViewModel(useCase, fetch)
            viewModel.saveClicked("0001", "nombre1 apellido1 apellido2")
            viewModel.saveClicked("0002", "nombre1 apellido1 apellido2")
            viewModel.obtainStudents()
            Log.d("@dev", "Stop")

    }
}