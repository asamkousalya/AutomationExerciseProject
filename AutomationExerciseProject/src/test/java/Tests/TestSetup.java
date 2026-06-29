package Tests;

import org.testng.annotations.*;
import utilities.BaseClass;

public class TestSetup extends BaseClass {

    @BeforeClass
    public void start() {
        setup();
    }

    @Test
    public void testRun() {
        System.out.println("Project running successfully ");
    }

    @AfterClass
    public void end() {
        tearDown();
    }
}