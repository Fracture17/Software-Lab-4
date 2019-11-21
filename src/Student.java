import java.util.ArrayList;
import java.util.Observable;

public class Student extends Observable {
    public Student(String name) {
        this.name = name;
    }

    public void addAssignmentScore(double as) {
        assignmentScores.add(as);
        setChanged();
        notifyObservers();
    }

    public void addExamScore(double es) {
        examScores.add(es);
        setChanged();
        notifyObservers();
    }

    public Iterable<Double> getAssignmentScores() {
        return assignmentScores;
    }

    public Iterable<Double> getExamsScores() {
        return examScores;
    }

    public double calcClassAverage(AverageCalculator calculator) {
        return calculator.calc(getAssignmentScores(), getExamsScores());
    }

    public String getName() {
        return name;
    }

    private ArrayList<Double> assignmentScores = new ArrayList<>();
    private ArrayList<Double> examScores = new ArrayList<>();
    private String name;
}
