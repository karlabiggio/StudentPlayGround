package edu.iesam.studentplayground.features.students.domain

import edu.iesam.studentplayground.features.students.data.StudentDataRepository


class SaveStudentUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(student: Student) {
        studentRepository.save(student)
    }

}