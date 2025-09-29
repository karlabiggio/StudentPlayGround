package edu.iesam.studentplayground.features.students.domain

class FetchStudentsUseCase(private val studentRepository: StudentRepository) {

    operator fun invoke(): List<Student>{
        return studentRepository.getStudents()
    }
}