import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        showCalculators();
        System.out.println();

        showTracker();
        System.out.println();

        showIterator();
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

    public static void showTracker() {
        Student student = new Student("test");

        addExamScores(student, 50.9, 33.3);
        addAssignmentScores(student, 94.8, 63.7, 50.0);

        GradeTracker tracker = new GradeTracker(student, new WeightedAverageCalculator());

        System.out.println("Class Average: " + student.calcClassAverage(new WeightedAverageCalculator()));
        System.out.println("Tracker expected: F");
        System.out.println("Tracker actual: " + tracker.getLetterGrade());

        student.addExamScore(100.0);
        System.out.println("Add exam score of 100.0");
        System.out.println("New score: " + student.calcClassAverage(new WeightedAverageCalculator()));
        System.out.println("Tracker expected: D");
        System.out.println("Tracker actual: " + tracker.getLetterGrade());
    }

    public static void showIterator() {
        System.out.println("Student 1:");
        Student student = new Student("test");

        addExamScores(student, 50.9, 33.3);
        addAssignmentScores(student, 94.8, 63.7, 50.0);

        System.out.println("Student 2");
        Student student2 = new Student("test2");

        addExamScores(student2, 17.9, 33.3);
        addAssignmentScores(student2, 94.8, 63.7, 55.0);


        Roster roster = new Roster("test roster", "1");

        roster.addStudent(student);
        roster.addStudent(student2);

        System.out.println("Student Averages:");
        WeightedAverageCalculator calculator = new WeightedAverageCalculator();
        for (AvgDispenser it = roster.getAverages(calculator); it.hasNext(); ) {
            Double score = (Double) it.next();
            System.out.println(score);
        }
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
