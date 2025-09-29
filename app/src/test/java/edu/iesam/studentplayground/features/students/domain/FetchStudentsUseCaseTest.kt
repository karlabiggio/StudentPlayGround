package edu.iesam.studentplayground.features.students.domain

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class FetchStudentsUseCaseTest {

    @Test
    fun `when invoke return students`() {
        //given
        val studentRepositoryMock = mockk<StudentRepository>()
        val fetchStudentsUseCase = FetchStudentsUseCase(studentRepositoryMock)
        val students = listOf(
            Student(exp = "0001", "Nombre0001"),
            Student(exp = "0002", "Nombre0002")
        )

        every { studentRepositoryMock.getStudents() } returns students

        //when
        val resultStudents = fetchStudentsUseCase.invoke()

        //then
        verify(exactly = 1) { studentRepositoryMock.getStudents() }
        assert(resultStudents.size == 2)
        assert(resultStudents == students)
        assert(resultStudents[0].exp == "0001")
        assert(resultStudents[0].name == "Nombre0001")
    }

}