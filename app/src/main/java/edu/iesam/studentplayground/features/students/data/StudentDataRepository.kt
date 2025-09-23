package edu.iesam.studentplayground.features.students.data

import edu.iesam.studentplayground.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.studentplayground.features.students.data.local.StudentMemLocalDataSource
import org.example.edu.iesam.students.data.local.StudentXmlLocalDataSource
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.StudentRepository

class StudentDataRepository(
    private val xmlLocalDataSource: StudentXmlLocalDataSource,
    private val memLocalDataSource: StudentMemLocalDataSource,
    private val apiRemoteDataSource: StudentApiRemoteDataSource
) : StudentRepository{

    override fun save(student: Student) {
        memLocalDataSource.save(student)
    }

    override fun getStudents(): List<Student> {
        return memLocalDataSource.obtainStudents()
    }


    override fun delete(student: Student) {
        memLocalDataSource.delete(student)
    }

}