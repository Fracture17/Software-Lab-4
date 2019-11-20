import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("test");

        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(17.9);
        examScores.add(33.3);

        System.out.print("Exam Scores: ");
        for(Double x: examScores) {
            System.out.print(x + ", ");
            student.addExamScore(x);
        }
        System.out.println();

        ArrayList<Double> assignmentScores = new ArrayList<>();
        assignmentScores.add(94.8);
        assignmentScores.add(63.7);
        assignmentScores.add(55.0);

        System.out.print("Assignment Scores: ");
        for(Double x: assignmentScores) {
            System.out.print(x + ", ");
            student.addAssignmentScore(x);
        }
        System.out.println();

        WeightedAverageCalculator calculator = new WeightedAverageCalculator();
        System.out.println("Method A expected: " + 43.826);
        System.out.println("Method A actual: " + student.calcClassAverage(calculator));

        CurvedWeightedAverageCalculator curvedCalculator = new CurvedWeightedAverageCalculator();
        System.out.println("Method B expected: " + 47.06);
        System.out.println("Method B actual: " + student.calcClassAverage(curvedCalculator));

        System.out.println("Method A expected: " + 43.826);
        System.out.println("Method A actual: " + student.calcClassAverage(calculator));
    }
}
