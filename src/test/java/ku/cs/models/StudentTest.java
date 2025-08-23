package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการสร้างนักเรียนด้วย ID และ ชื่อ")
    void testCreateStudentWithIdAndName() {
        Student s = new Student("6710405419", "StudentTest");
        assertEquals("6710405419", s.getId());
        assertEquals("StudentTest", s.getName());
        assertEquals(0.0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการสร้างนักเรียนด้วย ID, ชื่อ และ คะแนน")
    void testCreateStudentWithIdNameAndScore() {
        Student s = new Student("6710405419", "Yoshi", 100);
        assertEquals("6710405419", s.getId());
        assertEquals("Yoshi", s.getName());
        assertEquals(100.0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6710405419", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6710405419", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อของนักเรียน")
    void testChangeName() {
        Student s = new Student("6710405419", "StudentTest");
        s.changeName("NewName");
        assertEquals("NewName", s.getName());
    }

    @Test
    @DisplayName("เช็คดึงข้อมูลเกรดเกรด และเช็คเกรดจากไอดี")
    void testViewGrade() {
        Student s = new Student("6710405419", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปรียบเทียบ ID ของนักเรียน")
    void testIsId() {
        Student s = new Student("6710405419", "StudentTest");
        assertTrue(s.isId("6710405419"));
        assertFalse(s.isId("1234567890"));
    }

    @Test
    @DisplayName("ทดสอบการค้นหาชื่อของนักเรียน")
    void testIsNameContains() {
        Student s = new Student("6710405419", "StudentTest");
        assertTrue(s.isNameContains("Student"));
        assertFalse(s.isNameContains("Teacher"));
    }

    @Test
    @DisplayName("ทดสอบการแสดงผลของนักเรียน")
    void testToString() {
        Student s = new Student("6710405419", "StudentTest", 90.0);
        String expected = "{id: '6710405419', name: 'StudentTest', score: 90.0}";
        assertEquals(expected, s.toString());
    }

    @Test
    @DisplayName("ทดสอบการรดึงข้อมูลนักเรียนID ชื่อ คะแนน และเกรด")
    void testGetters() {
        Student s = new Student("6710405419", "StudentTest", 100.0);
        assertEquals("6710405419", s.getId());
        assertEquals("StudentTest", s.getName());
        assertEquals(100.0, s.getScore());
        assertEquals("A", s.getGrade());
    }
}