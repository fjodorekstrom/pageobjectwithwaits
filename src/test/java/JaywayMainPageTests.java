import helpers.JaywayMainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * Created with IntelliJ IDEA.
 * User: fjodorekstrom
 * Date: 3/20/13
 * Time: 8:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class JaywayMainPageTests {
    private JaywayMainPage page;

    @Before
    public void setUp() {
        page = PageFactory.initElements(new FirefoxDriver(), JaywayMainPage.class);
        page.open();
        page.setElementVariables();
    }

    @After
    public void tearDown() {
        page.close();
    }

    @Test
    public void searchOnFjodor() {
        page.searchFor("Fjodor");
        assertThat(page.getTitle(), containsString("Fjodor"));
    }
}
