package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.generator.FacultyGenerator;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.hogwarts.school.generator.FacultyGenerator.*;
import static ru.hogwarts.school.generator.StudentGenerator.ID;

class FacultyServiceTest {

    private FacultyRepository facultyRepository;
    private final FacultyService facultyService = new FacultyService(facultyRepository);

    @Test
    void addFaculty_success() {

//        Входные данные.

        Faculty faculty = new Faculty(ID, NAME, COLOR);

//        Ожидаемый результат.

        Faculty expected = getStudent();

//        Тест.

        Faculty actual = facultyService.addFaculty(faculty);
        assertEquals(expected, actual);
    }

    @Test
    void findFaculty_success() {

//        Входные данные.

        Faculty faculty = new Faculty(ID, NAME, COLOR);
        Long id = ID;

//        Ожидаемый результат.

        facultyService.addFaculty(faculty);
        Faculty expected = getStudent();

//        Тест.

        Faculty actual = facultyService.findFaculty(id);
        assertEquals(expected, actual);
    }

    @Test
    void editFaculty_success() {

//        Входные данные.

        Faculty faculty = new Faculty(ID, NAME, COLOR);

//        Ожидаемый результат.

        Faculty expected = null;

//        Тест.

        Faculty actual = facultyService.editFaculty(faculty);
        assertEquals(expected, actual);
    }

    @Test
    void deleteFaculty_success() {

//        Входные данные.

        Long id = ID;

//        Тест.

        assertThrows(RuntimeException.class, () -> facultyService.deleteFaculty(id));

    }

    @Test
    void findByColor_success() {

//        Входные данные.

        Faculty faculty = new Faculty(ID, NAME, COLOR);
        String color = COLOR;

//        Ожидаемый результат.

        facultyService.addFaculty(faculty);
        ArrayList<Faculty> expected = new ArrayList<>(List.of(getStudent()));

//        Тест.

        Collection<Faculty> actual = facultyService.findByColor(color);
        assertEquals(expected, actual);
    }
}