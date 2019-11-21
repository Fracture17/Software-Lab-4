import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Observable;

public class Student extends Observable {
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

    public double calcClassAverage(AverageCalculator calculator) {
        return calculator.calc(getAssignmentScores(), getExamsScores());
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }

    private ArrayList<Double> assignmentScores = new ArrayList<>();
    private ArrayList<Double> examScores = new ArrayList<>();
    private String name;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
}
