import java.util.ArrayList;

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

    String courseName;
    String courseNumber;
    ArrayList<Student> students = new ArrayList<>();
}
