package edu.iesam.studentplayground.features.students.domain

interface StudentRepository {

    fun save(student: Student)
    fun getStudents() : List<Student>
    fun delete(exp: String)

}