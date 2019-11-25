import java.util.Iterator;

public class AvgDispenser implements Iterator {
    public AvgDispenser(Iterator<Student> students, AverageCalculator calculator) {
        this.students = students;
        this.calculator = calculator;
    }

    @Override
    public boolean hasNext() {
        return students.hasNext();
    }

    @Override
    public Object next() {
        return students.next().calcClassAverage(calculator);
    }

    private Iterator<Student> students;
    private AverageCalculator calculator;
}
