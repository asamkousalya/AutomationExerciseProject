package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;

public class Hooks extends BaseClass{
	@Before
    public void launchBrowser() {
        setup();
    }
 
    @After
    public void closeBrowser() {
        tearDown();
    }

}
