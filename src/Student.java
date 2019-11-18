import java.util.ArrayList;

public class Student {
    public Student(String name) {
        this.name = name;
    }

    public void addAssignmentScore(double as) {
        assignmentScores.add(as);
    }

    public void addExamScore(double es) {
        examScores.add(es);
    }

    public Iterable<Double> getAssignmentScores() {
        return assignmentScores;
    }

    public Iterable<Double> getExamsScores() {
        return examScores;
    }

    private ArrayList<Double> assignmentScores = new ArrayList<>();
    private ArrayList<Double> examScores = new ArrayList<>();
    private String name;
}
