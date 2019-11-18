import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WeightedAverageCalculatorTest {
    @Test
    public void test_correctlyCalculatesAverage() {
        //exams scores
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(21.0);
        examScores.add(10.1);

        examScores.sort(Double::compareTo);

        Student student = new Student("test");

        for(Double x: examScores) {
            student.addExamScore(x);
        }


        //assignment scores
        ArrayList<Double> assignmentScores = new ArrayList<>();
        assignmentScores.add(18.9);
        assignmentScores.add(54.2);

        assignmentScores.sort(Double::compareTo);

        for(Double x: assignmentScores) {
            student.addAssignmentScore(x);
        }



        WeightedAverageCalculator calculator = new WeightedAverageCalculator();
        assertEquals(23.95, calculator.calc(student.getAssignmentScores(), student.getExamsScores()));
    }
}