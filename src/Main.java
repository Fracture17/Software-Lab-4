import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        showCalculators();
    }

    public static void showCalculators() {
        Student student = new Student("test");

        addExamScores(student, 17.9, 33.3);
        addAssignmentScores(student, 94.8, 63.7, 55.0);

        WeightedAverageCalculator calculator = new WeightedAverageCalculator();
        System.out.println("Method A expected: " + 43.826);
        System.out.println("Method A actual: " + student.calcClassAverage(calculator));

        CurvedWeightedAverageCalculator curvedCalculator = new CurvedWeightedAverageCalculator();
        System.out.println("Method B expected: " + 47.06);
        System.out.println("Method B actual: " + student.calcClassAverage(curvedCalculator));

        System.out.println("Method A expected: " + 43.826);
        System.out.println("Method A actual: " + student.calcClassAverage(calculator));
    }

    public static void addExamScores(Student student, double... scores) {
        System.out.print("Exam Scores: ");
        for(Double x: scores) {
            System.out.print(x + ", ");
            student.addExamScore(x);
        }
        System.out.println();
    }

    public static void addAssignmentScores(Student student, double... scores) {
        System.out.print("Assignment Scores: ");
        for(Double x: scores) {
            System.out.print(x + ", ");
            student.addAssignmentScore(x);
        }
        System.out.println();
    }
}
