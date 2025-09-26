package edu.iesam.studentplayground.features.students.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.studentplayground.features.students.domain.DeleteStudentUseCase
import edu.iesam.studentplayground.features.students.domain.FetchStudentsUseCase
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.UpdateStudentUseCase

class StudentViewModel(private val saveStudentUseCase: SaveStudentUseCase, private val fetchStudentsUseCase: FetchStudentsUseCase, private val deleteStudentUseCase: DeleteStudentUseCase, private val updateStudentUseCase: UpdateStudentUseCase) : ViewModel() {

    fun saveClicked(exp: String, name: String) {
        saveStudentUseCase.invoke(Student(exp, name))
    }

    fun obtainStudents() : List<Student>{
        return fetchStudentsUseCase.invoke()
    }

    fun deleteStudent(exp: String) {
        deleteStudentUseCase.invoke(exp)
    }
    fun updateStudent(exp: String, newName: String){
        updateStudentUseCase.invoke(exp, newName)
    }

}