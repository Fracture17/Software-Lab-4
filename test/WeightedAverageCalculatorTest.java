import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WeightedAverageCalculatorTest {
    @Before
    public void setup() {
        student = new Student("test");
        examScores = new ArrayList<>();
        assignmentScores = new ArrayList<>();
    }

    @Test
    public void test_correctlyCalculatesAverage() {
        addExamScores(21.0, 10.1);

        addAssignmentScores(18.9, 54.2);

        WeightedAverageCalculator calculator = new WeightedAverageCalculator();
        assertEquals(23.95, calculator.calc(student.getAssignmentScores(), student.getExamsScores()), 0.01);
    }

    public void addAssignmentScores(double... scores) {
        for(double score: scores) {
            assignmentScores.add(score);
            student.addAssignmentScore(score);
        }
        assignmentScores.sort(Double::compareTo);
    }

    public void addExamScores(double... scores) {
        for(double score: scores) {
            examScores.add(score);
            student.addExamScore(score);
        }
        examScores.sort(Double::compareTo);
    }

    protected Student student;
    protected ArrayList<Double> examScores;
    protected ArrayList<Double> assignmentScores;
}