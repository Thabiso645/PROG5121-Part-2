package za.ac.iie.prog5121.part1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the login class
 */
public class LoginTest {

    /**
     * Test username correctly formatted
     * 
     * Test Data: "kyl_1"
    */
    @Test
    public void testUsernameCorrectlyFormatted() {
        Login user = new Login();
        user.setUsername("kyl_1");
        assertTrue(user.checkUserName());
    }
    
    /**
     * Test username incorrectly formatted.
     * 
     * Test Data: "kyle!!!!!!!"
     */
    @Test
    public void testUsernameIncorrectlyFormatted() {
       Login user = new Login();
        user.setUsername("kyle!!!!!!!");
        assertFalse(user.checkUserName());
    }
          
/**
 * Test password meets the complexity requirements.
 * 
 * Test Data: "Ch&seck@ke99!"
 */
    @Test
    public void testPasswordMeetsComplexityRequirements() {
        Login user = new Login();
        user.setPassword("Ch&seck@ke99!");
        assertTrue(user.checkPasswordComplexity());
    }
    
/**
 * Test password does not meet complexity requirements.
 * 
 * Test Data: "password"
 */
    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        Login user = new Login();
        user.setPassword("password");
        assertFalse(user.checkPasswordComplexity());
    }
    
/**
 * Test cell phone number formatted correctly.
 * 
 * Test Data: +2786577904
 */
    @Test
    public void testCellPhoneNumberFormattedCorrectly() {
        Login user = new Login();
        user.setCellPhoneNumber("+27786577904");
        assertTrue(user.checkCellPhoneNumber());
    }
    
    /**
     * Test cell phone number formatted incorrectly.
     * 
     * Test Data: 08966553
     */
    @Test
    public void testCellPhoneNumberFormattedIncorrectly() {
        Login user = new Login();
        user.setCellPhoneNumber("089966553");
        assertFalse(user.checkCellPhoneNumber());
    }        
    
    /**
     * Test successful login.
     */
    @Test
    public void testLoginSuccessful() {
        Login user = new Login(
        "kyl_1",
        "Ch&seck@ke99!",
        "+27786577904",
        "Kyle",
        "Smith"
    );
        
        boolean result = user.loginUser(
        "kyl_1",
        "Ch&seck@ke99!"
    );
    
        assertTrue(result);
    }
    
    /**
     * Test failed login.
     */
    @Test
    public void testLoginFailed() {
        Login user = new Login(
        "kyl_1",
        "Ch&seck@ke99!",
        "+27786577904",
        "Kyle",
        "Smith"
    );
        boolean result = user.loginUser(
        "kyl_1",
        "wrongPassword"
        );
        assertFalse(result);
    }
    
    /**
    Test successful login message.
    */
    @Test
    public void testSuccessfullLoginMessage() {
        Login user = new Login(
        "kyl_1",
        "Ch&se@k@e99!",
        "+27786577904",
        "Kyle",
        "Smith"
        );
        
        String result = user.returnLoginStatus(true);
        assertEquals(
        "Welcome Kyle Smith, it is great to see you again.",
                result
        );
    }
    
    /**
     * Test failed login message.
     */
    @Test
    public void testFailedLoginMessage() {
        Login user = new Login(
        "kyl_1",
        "Ch&seck@ke99!",
        "+27786577904",
        "Kyle",
        "Smith"
        );
        
        String result = user.returnLoginStatus(false);
        assertEquals(
        "Username or password is incorrect, please try again.",
                result
        );
    }
}
    
