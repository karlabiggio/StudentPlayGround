package edu.iesam.studentplayground.features.students.domain

class UpdateStudentUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(exp: String, newName: String){
        studentRepository.update(exp, newName)
    }

}