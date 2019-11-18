import org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {
    public void assertStudentAssignmentScoresAreCorrect(Student student,
                                                            ArrayList<Double> assignmentScores) {
        ArrayList<Double> studentScores = new ArrayList<>();
        for(Double x: student.getAssignmentScores()) {
            studentScores.add(x);
        }
        studentScores.sort(Double::compareTo);
        assertArrayEquals(studentScores.toArray(), assignmentScores.toArray());
    }

    @Test
    public void test_assignmentsCanBeAddedAndRetrieved() {
        ArrayList<Double> assignmentScores = new ArrayList<>();
        assignmentScores.add(21.0);
        assignmentScores.add(10.1);

        assignmentScores.sort(Double::compareTo);

        Student student = new Student("test");

        for(Double x: assignmentScores) {
            student.addAssignmentScore(x);
        }

        assertStudentAssignmentScoresAreCorrect(student, assignmentScores);
    }

    public void assertStudentExamScoresAreCorrect(Student student,
                                                        ArrayList<Double> examScore) {
        ArrayList<Double> studentScores = new ArrayList<>();
        for(Double x: student.getExamsScores()) {
            studentScores.add(x);
        }
        studentScores.sort(Double::compareTo);
        assertArrayEquals(studentScores.toArray(), examScore.toArray());
    }

    @Test
    public void test_examsCanBeAddedAndRetrieved() {
        ArrayList<Double> assignmentScores = new ArrayList<>();
        assignmentScores.add(21.0);
        assignmentScores.add(10.1);

        assignmentScores.sort(Double::compareTo);

        Student student = new Student("test");

        for(Double x: assignmentScores) {
            student.addExamScore(x);
        }

        assertStudentExamScoresAreCorrect(student, assignmentScores);
    }
}