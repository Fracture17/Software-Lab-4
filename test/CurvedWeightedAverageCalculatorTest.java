import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurvedWeightedAverageCalculatorTest extends WeightedAverageCalculatorTest{
    @Test
    public void test_correctlyCalculatesAverage() {
        addExamScores(21.0, 10.1);

        addAssignmentScores(18.9, 54.2);

        CurvedWeightedAverageCalculator calculator = new CurvedWeightedAverageCalculator();
        assertEquals(31.01, calculator.calc(student.getAssignmentScores(), student.getExamsScores()), .001);
    }

    @Test
    public void test_correctlyCalculatesSingleAssignmentAverage() {
        addExamScores(21.0, 10.1);

        addAssignmentScores(54.2);

        CurvedWeightedAverageCalculator calculator = new CurvedWeightedAverageCalculator();
        assertEquals(31.01, calculator.calc(student.getAssignmentScores(), student.getExamsScores()), .001);
    }
}