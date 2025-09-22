package edu.iesam.studentplayground.features.students.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.studentplayground.features.students.domain.FetchStudentsUseCase
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.StudentRepository

class StudentViewModel(private val saveStudentUseCase: SaveStudentUseCase, private val fetchStudentsUseCase: FetchStudentsUseCase) : ViewModel() {

    fun saveClicked(exp: String, name: String) {
        saveStudentUseCase.invoke(Student(exp, name))
    }

    fun obtainStudents() : List<Student>{
        return fetchStudentsUseCase.invoke()
    }

}