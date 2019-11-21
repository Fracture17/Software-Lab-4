import org.junit.Test;

//import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import org.junit.Assert.*;

import org.junit.Assert.*;
import org.junit.Test;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeTrackerTest {
    @Test
    public void test_gradeTrackerAutomaticallyUpdates() {
        Student student = new Student("test");

        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(50.9);
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

        GradeTracker tracker = new GradeTracker(student, new WeightedAverageCalculator());
        assertEquals("F", tracker.getLetterGrade());

        student.addExamScore(100);
        assertEquals("D", tracker.getLetterGrade());
    }
}