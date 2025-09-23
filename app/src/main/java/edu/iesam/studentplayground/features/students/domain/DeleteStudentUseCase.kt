package edu.iesam.studentplayground.features.students.domain

class DeleteStudentUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(student: Student){
        studentRepository.delete(student)
    }

}