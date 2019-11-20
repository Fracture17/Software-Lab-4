import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GradeTracker implements PropertyChangeListener {
    public GradeTracker(Student student) {

    }

    public String getLetterGrade() {
        return letterGrade;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    private String letterGrade;
}
