package uk.co.F1x2Games.selenium.main;

import static org.junit.Assert.fail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.jt.selenium.SeleniumJT;
//import com.jt.selenium.factory.SeleniumJTFactory;
//import com.jt.selenium.testng.SeleniumTestNG;

//import uk.co.F1x2Games.selenium.page.CentralAdminPO;
import uk.co.F1x2Games.utils.DatabaseUtilities;


/**
 * This is a very simple sample test to verify the project is run correctly.
 * 
 * This class illustrates how to use PageObjects within a Java Test class. It is run via XML, simply running this test
 * standalone will not work as the framework requires extra data that only the XML can provide.
 * 
 * @author Billy.Sneddon
 * 
 */
public class CentralAdminTest /*extends SeleniumTestNG*/ {

    private static final Logger LOGGER = LoggerFactory.getLogger(CentralAdminTest.class);
    //private SeleniumJT test;
    //private CentralAdminPO centralAdminPO;

    //@Override
    @BeforeClass(alwaysRun = true)
    public void startSession(ITestContext context) throws Exception {
        //test = SeleniumJTFactory.getSeleniumJT(context);
       // centralAdminPO = new CentralAdminPO(test);
    }

   // @Override
    @AfterClass(alwaysRun = true)
    public void afterClass(ITestContext context) throws Exception {
        //test.stop();
    }

    @BeforeTest
    public void before() {
        DatabaseUtilities.cleanDB();
    }

    /**
     * Note  - some of the logic here is effectively duplicated from the cucumber tests perhaps should
     * push more of the code from the testSteps classes into the PO classes which would better allow reuse here?
     */
    @Test
    public void testUserSkills() throws Exception {

        try {
           
            // verify skill added somehow
        } catch (Throwable e) {
            LOGGER.info("Exception thrown " + e.getMessage());
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testAdminSkills() throws Exception {
        try {
            // Login as user
            /*centralAdminPO.logMeIn(PropertiesFileReader.getAdminEmail(), PropertiesFileReader.getAdminPassword(),
                    PageType.PAGETYPE_ADMIN);
*/
            /*centralAdminPO.openAdminPage();
            centralAdminPO.addNewSkills();
            centralAdminPO.triggerDropDown();
            centralAdminPO.selectSkill(NEW_SKILL);
            centralAdminPO.saveSkill();

            centralAdminPO.addNewSkills();
            centralAdminPO.triggerDropDown();
            centralAdminPO.selectSkill(OTHER_SKILL);
            centralAdminPO.saveSkill();

            centralAdminPO.logout();*/

            // verify skill added somehow
        } catch (Throwable e) {
            LOGGER.info("Exception thrown " + e.getMessage());
            fail();
        }
    }

   
    

}
