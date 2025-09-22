package edu.iesam.studentplayground.features.students.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.domain.Student

class StudentViewModel(private val saveStudentUseCase: SaveStudentUseCase) : ViewModel() {

    fun saveClicked(exp: String, name: String) {
        saveStudentUseCase.invoke(Student(exp, name))
    }

}