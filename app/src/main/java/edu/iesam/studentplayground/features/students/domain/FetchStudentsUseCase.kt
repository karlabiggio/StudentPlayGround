package edu.iesam.studentplayground.features.students.domain

class FetchStudentsUseCase(val studentRepository: StudentRepository) {

    operator fun invoke() : List<Student>{
        return studentRepository.getStudents()
    }
}