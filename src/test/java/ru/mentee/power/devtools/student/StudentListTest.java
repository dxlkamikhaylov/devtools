package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentListTest {

  @Test
  void shouldAddStudent() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Daniil", "Krasnoyarsk"));
    assertEquals(1, list.getStudentsByCity("Krasnoyarsk").size());
  }

  @Test
  void shouldNotAddNullStudent() {
    StudentList list = new StudentList();
    list.addStudent(null);
    assertTrue(list.getStudentsByCity("Krasnoyarsk").isEmpty());
  }

  @Test
  void shouldReturnStudentsByCity() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Daniil", "Krasnoyarsk"));
    list.addStudent(new Student("Roma", "SPb"));
    list.addStudent(new Student("Daniil", "Krasnoyarsk"));

    List<Student> krasnoyarsk = list.getStudentsByCity("Krasnoyarsk");
    assertEquals(2, krasnoyarsk.size());
  }

  @Test
  void shouldReturnEmptyForUnknownCity() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Daniil", "Krasnoyarsk"));
    assertTrue(list.getStudentsByCity("Abakan").isEmpty());
  }

  @Test
  void shouldNotDeduplicateStudents() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Daniil", "Krasnoyarsk"));
    list.addStudent(new Student("Roma", "SPb"));
    list.addStudent(new Student("Daniil", "Krasnoyarsk"));

    List<Student> krasnoyarsk = list.getStudentsByCity("Krasnoyarsk");

    assertEquals(2, krasnoyarsk.size());

  }

}
