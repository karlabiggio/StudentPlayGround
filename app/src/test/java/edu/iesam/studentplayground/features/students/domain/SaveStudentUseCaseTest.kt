package edu.iesam.studentplayground.features.students.domain

import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SaveStudentUseCaseTest {

    @Test
    fun `when invoke then save student`(){
        //Given
        val studentRepositoryMock = mockk<StudentRepository>(relaxed = true)
        val saveStudentUseCase = SaveStudentUseCase(studentRepositoryMock)
        val student = Student(exp = "001", "Name1")

        //When
        saveStudentUseCase.invoke(student) //se podria quitar el invoke

        //Then
        verify(exactly = 1){ studentRepositoryMock.save(student = student) } //el verify se asegura que el metodo se ha ejecutado

    }
    
}