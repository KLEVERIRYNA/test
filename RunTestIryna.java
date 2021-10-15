import org.junit.jupiter.api.Test;

public class RunTestIryna {
    @Test
    public void runTest() {

        TestClassIryna firstClass = new TestClassIryna();
        System.out.println(firstClass.fuelRate(8,300));
    }
}