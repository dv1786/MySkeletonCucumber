package skeleton;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hook extends ProjectUtils {

    private ProjectUtils base;

    public Hook(ProjectUtils base) {
        this.base = base;
    }

    @Before
    public void checkName() {
        //браузер висит постоянно
        base.driver = new ChromeDriver();
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        base.driver.manage().window().maximize();


    }

    @After
    public void testFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
    }
}
