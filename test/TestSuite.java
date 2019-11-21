import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CurvedWeightedAverageCalculatorTest.class,
        WeightedAverageCalculatorTest.class,
        StudentTest.class,
        GradeTrackerTest.class,
        RosterTest.class
})

public final class TestSuite {
}  