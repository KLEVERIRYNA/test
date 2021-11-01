package homework;

import org.junit.jupiter.api.Test;

import java.sql.Struct;

public class TestCredit {
    public boolean checkCredit(int creditSum, int finalSum) {
        int first10Years = creditSum * 10 / 100;
        int second10Years = (creditSum - first10Years) * 8 / 100;
        int third10Years = (creditSum - first10Years - second10Years) * 6 / 100;
        if (finalSum == (first10Years + second10Years + third10Years)) {
            return true;
        }
        return false;
    }

    @Test
    public void runTest() {

        TestCredit checkCredit  = new TestCredit();
        if(checkCredit.checkCredit(10000, 18000) == true) {

            System.out.println("ok");
        } else {
            System.out.println("bad");
        }
    }

}