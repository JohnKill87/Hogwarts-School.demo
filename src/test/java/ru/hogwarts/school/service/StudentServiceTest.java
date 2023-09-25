package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.generator.StudentGenerator;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.hogwarts.school.generator.StudentGenerator.*;

class StudentServiceTest {

    private final StudentService studentService = new StudentService();

    @Test
    void addStudent_success() {

//        Входные данные.

        Student student = new Student(ID, NAME, AGE);

//        Ожидаемый результат.

        Student expected = getStudent();

//        Тест.

        Student actual = studentService.addStudent(student);
        assertEquals(expected, actual);
    }

    @Test
    void findStudent_success() {

//        Входные данные.

        Student student = new Student(ID, NAME, AGE);
        Long id = ID;

//        Ожидаемый результат.

        studentService.addStudent(student);
        Student expected = getStudent();

//        Тест.

        Student actual = studentService.findStudent(id);
        assertEquals(expected, actual);
    }

    @Test
    void editStudent_success() {

//        Входные данные.

        Student student = new Student(ID, NAME, AGE);

//        Ожидаемый результат.

        Student expected = null;

//        Тест.

        Student actual = studentService.editStudent(student);
        assertEquals(expected, actual);
    }

    @Test
    void deleteStudent_success() {

//        Входные данные.

        Student student = new Student(ID, NAME, AGE);
        Long id = ID;

//        Ожидаемый результат.

        studentService.addStudent(student);
        Student expected = getStudent();

//        Тест.
        Student actual = studentService.deleteStudent(id);
        assertEquals(expected, actual);
    }

    @Test
    void findByAge_success() {

//        Входные данные.

        Student student = new Student(ID, NAME, AGE);
        int age = AGE;

//        Ожидаемый результат.

        studentService.addStudent(student);
        ArrayList<Student> expected = new ArrayList<>(List.of(getStudent()));

//        Тест.

        Collection<Student> actual = studentService.findByAge(age);
        assertEquals(expected, actual);
    }
}