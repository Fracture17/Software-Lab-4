import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

public class GradeTracker implements Observer {
    public GradeTracker(Student student, AverageCalculator calculator) {
        this.calculator = calculator;
        student.addObserver(this);
        updateLetterGrade(student.calcClassAverage(calculator));
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    @Override
    public void update(Observable observable, Object o) {
        Student student = (Student) o;
        double newScore = student.calcClassAverage(calculator);
        updateLetterGrade(newScore);
    }

    private void updateLetterGrade(double newScore) {
        if(newScore >= 90) {
            letterGrade = "A";
        }
        else if(newScore >= 80) {
            letterGrade = "B";
        }
        else if(newScore >= 70) {
            letterGrade = "B";
        }
        else if(newScore >= 60) {
            letterGrade = "B";
        }
        else {
            letterGrade = "F";
        }
    }

    private String letterGrade;
    private AverageCalculator calculator;
}
