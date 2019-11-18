import org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {
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

    public void assertStudentAssignmentScoresAreCorrect(Student student,
                                                        ArrayList<Double> assignmentScores) {
        assertScoresAreCorrect(student.getAssignmentScores(), assignmentScores);
    }

    @Test
    public void test_examsCanBeAddedAndRetrieved() {
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(21.0);
        examScores.add(10.1);

        examScores.sort(Double::compareTo);

        Student student = new Student("test");

        for(Double x: examScores) {
            student.addExamScore(x);
        }

        assertStudentExamScoresAreCorrect(student, examScores);
    }

    public void assertStudentExamScoresAreCorrect(Student student,
                                                  ArrayList<Double> examScores) {
        assertScoresAreCorrect(student.getExamsScores(), examScores);
    }

    public void assertScoresAreCorrect(Iterable<Double> studentScores, ArrayList<Double> expectedScores) {
        ArrayList<Double> studentScoreList = new ArrayList<>();
        for(Double x: studentScores) {
            studentScoreList.add(x);
        }
        studentScoreList.sort(Double::compareTo);
        assertArrayEquals(studentScoreList.toArray(), expectedScores.toArray());
    }
}