import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WeightedAverageCalculatorTest {
    @BeforeEach
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
        assertEquals(23.95, calculator.calc(student.getAssignmentScores(), student.getExamsScores()));
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