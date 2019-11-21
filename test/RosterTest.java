import org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RosterTest {
    @Test
    public void test_studentIterator() {
        Roster roster = new Roster("test", "0");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("1"));
        students.add(new Student("2"));
        students.add(new Student("3"));
        students.sort((a, b) -> a.getName().compareTo(b.getName()));

        for(Student s: students) {
            roster.addStudent(s);
        }

        ArrayList<Student> studentRoster = new ArrayList<>();
        for (ListIterator<Student> it = roster.getStudents(); it.hasNext(); ) {
            Student s = it.next();
            studentRoster.add(s);
        }

        studentRoster.sort((a, b) -> a.getName().compareTo(b.getName()));

        assertArrayEquals(students.toArray(), studentRoster.toArray());
    }
}