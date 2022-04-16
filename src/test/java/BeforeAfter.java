import functionLibrary.CommonFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BeforeAfter {
     CommonFunctions commonFunctions = new CommonFunctions();


    @Before
    public void beforeTest()
    {
        commonFunctions.openBrowser();
    }
    @After
    public void afterTest()
    {
        commonFunctions.closeBrowser();
    }
}
