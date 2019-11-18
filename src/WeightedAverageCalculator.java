import java.util.ArrayList;

public class WeightedAverageCalculator implements AverageCalculator {
    @Override
    public double calc(Iterable<Double> assignmentScores, Iterable<Double> examScores) {
        return calc(iterableToList(assignmentScores), iterableToList(examScores));
    }

    private <T> ArrayList<T> iterableToList(Iterable<T> iterable) {
        ArrayList<T> list = new ArrayList<>();
        for(T x: iterable) {
            list.add(x);
        }
        return list;
    }

    private double calc(ArrayList<Double> assignmentScores, ArrayList<Double> examScores) {
        double assigmentAverage = computeAssignmentAverage(assignmentScores);
        double examAverage = computeExamAverage(examScores);

        return assigmentAverage * ASSIGNMENT_WEIGHT + examAverage * EXAM_WEIGHT;
    }

    private double computeAssignmentAverage(ArrayList<Double> assignmentScores) {
        double assignmentTotal = 0;
        for(Double x: assignmentScores) {
            assignmentTotal += x;
        }

        double assigmentAverage = assignmentTotal / assignmentScores.size();
        return assigmentAverage;
    }

    private double computeExamAverage(ArrayList<Double> examScores) {
        double examTotal = 0;
        for(Double x: examScores) {
            examTotal += x;
        }

        double examAverage = examTotal / examScores.size();
        return examAverage;
    }

    private static final double ASSIGNMENT_WEIGHT = .4;
    private static final double EXAM_WEIGHT = .6;
}
