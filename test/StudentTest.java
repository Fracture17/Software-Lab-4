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

    @Test void test_averageIsCorrectUsingDifferentMethods() {
        Student student = new Student("test");

        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(17.9);
        examScores.add(33.3);

        for(Double x: examScores) {
            student.addExamScore(x);
        }

        ArrayList<Double> assignmentScores = new ArrayList<>();
        assignmentScores.add(94.8);
        assignmentScores.add(63.7);
        assignmentScores.add(55.0);

        for(Double x: assignmentScores) {
            student.addAssignmentScore(x);
        }

        WeightedAverageCalculator calculator = new WeightedAverageCalculator();
        assertEquals(43.83, student.calcClassAverage(calculator), .01);

        CurvedWeightedAverageCalculator curvedCalculator = new CurvedWeightedAverageCalculator();
        assertEquals(47.06, student.calcClassAverage(curvedCalculator), .01);

        assertEquals(43.83, student.calcClassAverage(calculator), .01);
    }
}