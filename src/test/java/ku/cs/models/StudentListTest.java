package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList list = new StudentList();

    @BeforeEach
    void setUp() {
        list.addNewStudent("6710400001", "First", 70.0);
        list.addNewStudent("6710400002", "Second");
        list.addNewStudent("6710400003", "Third", 50);
        list.addNewStudent("6710400004", "Fourth");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่และการหานักเรียนด้วย ID")
    void testAddNewStudent() {
        list.addNewStudent("671040005", "Fifth");
        assertEquals("671040005", list.findStudentById("671040005").getId());
    }

    @Test
    @DisplayName("การค้นหานักเรียนที่มีด้วยชื่อ")
    void testFilterByName() {
        assertEquals("First", list.filterByName("First").getStudents().get(0).getName());
    }

    @Test
    @DisplayName("เช็คเกรดจาก ID")
    void testViewGradeOfId() {
        assertEquals("B", list.viewGradeOfId("6710400001"));
        assertEquals("F", list.viewGradeOfId("6710400002"));
        assertEquals("D", list.viewGradeOfId("6710400003"));
        assertEquals("F", list.viewGradeOfId("6710400004"));
    }

    @Test
    @DisplayName("ให้คะแนนเด็กจาก ID")
    void testAddScoreToStudentById() {
        list.giveScoreToId("6710400002", 90.0);
        assertEquals(90.0, list.findStudentById("6710400002").getScore());
    }

    @Test
    @DisplayName("ดึงข้อมูลนักเรียนทั้งหมด")
    void testGetStudents() {
        assertEquals(list.getStudents().size(), 4);
    }
}