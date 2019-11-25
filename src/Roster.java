import java.util.ArrayList;
import java.util.ListIterator;

public class Roster {
    public Roster(String name, String number) {
        this.courseName = name;
        this.courseNumber = number;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public AvgDispenser getAverages(AverageCalculator calculator) {
        return new AvgDispenser(students.iterator(), calculator);
    }

    private String courseName;
    private String courseNumber;
    private ArrayList<Student> students = new ArrayList<>();
}
