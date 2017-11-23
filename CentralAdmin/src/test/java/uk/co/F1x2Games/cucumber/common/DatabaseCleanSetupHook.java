package uk.co.F1x2Games.cucumber.common;

//import cucumber.api.java.Before;
import uk.co.F1x2Games.utils.DatabaseUtilities;

/**
 * The Class DatabaseCleanSetupHook. This will run before any Cucumber features annotated with @databaseClean
 * 
 * @author andy.palmer
 */
public class DatabaseCleanSetupHook {

    //@Before("@databaseClean")
    public void cleanDB() {
        DatabaseUtilities.cleanDB();
    }
}
