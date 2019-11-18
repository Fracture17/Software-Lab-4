import java.util.ArrayList;
import java.util.Collections;

public class CurvedWeightedAverageCalculator extends WeightedAverageCalculator {
    @Override
    protected double computeAssignmentAverage(ArrayList<Double> assignmentScores) {
        if(assignmentScores.size() >= 2) {
            assignmentScores.remove(Collections.min(assignmentScores));
        }
        return super.computeAssignmentAverage(assignmentScores);
    }
}
