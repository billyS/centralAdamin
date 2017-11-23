package uk.co.F1x2Games.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import com.jt.selenium.utils.FileHelper;
//import com.jt.selenium.utils.PropertiesHelper;


//TODO ADP once SeleniumJT has been fixed to use testdata.properties when running under JUnit this should be removed
public class PropertiesFileReader {

    private static final String ADMIN1_PASSWORD = "admin1.password";
    private static final String ADMIN1_EMAIL = "admin1.email";
    private static final String USER1_PASSWORD = "user1.password";
    private static final String USER1_EMAIL = "user1.email";
    private static final String USER2_PASSWORD = "user2.password";
    private static final String USER2_EMAIL = "user2.email";
    private static final String TARGET_BROWSER = "target.browser";
    private static final String TEST_DATA = "testdata.properties";
    private static final String USER_WITH_SKILLS_PASSWORD = "user.with.skills.password";
    private static final String USER_WITH_SKILLS_EMAIL = "user.with.skills.email";

    private static PropertiesFileReader instance;
    private final Properties props = new Properties();

   /* private PropertiesFileReader() {
        String testDataProps = String.format("%s%s", FileHelper.PROPERTIES_LOC, TEST_DATA);
        try (InputStream is = FileHelper.getInputStreamByClassLoader(testDataProps)) {
            // load testdata.properties
            props.load(is);
            // add selenium.properties and my.selenium.properties
            props.putAll(PropertiesHelper.getRuntimeProperties());
        } catch (IOException e) {
            throw new IllegalStateException(String.format("%s is missing", testDataProps), e);
        }
    }*/

    public static PropertiesFileReader getInstance() {
        if (instance == null) {
            instance = new PropertiesFileReader();
        }
        return instance;
    }

    public static String getTargetBrowser() {
        return getProperty(TARGET_BROWSER);
    }

    public static String getUser1Email() {
        return getProperty(USER1_EMAIL);
    }

    public static String getUser1Password() {
        return getProperty(USER1_PASSWORD);
    }

    public static String getUser2Email() {
        return getProperty(USER2_EMAIL);
    }

    public static String getUser2Password() {
        return getProperty(USER2_PASSWORD);
    }

    public static String getAdminEmail() {
        return getProperty(ADMIN1_EMAIL);
    }

    public static String getAdminPassword() {
        return getProperty(ADMIN1_PASSWORD);
    }

    public static String getProperty(String propertyName) {
        return getInstance().props.getProperty(propertyName);
    }

    public static String getUserWithSkillsPassword() {
        return getProperty(USER_WITH_SKILLS_PASSWORD);
    }

    public static String getUserWithSkillsEmail() {
        return getProperty(USER_WITH_SKILLS_EMAIL);
    }

}