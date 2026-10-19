/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.prog5121.part1;

/**
 *
 * @author thabiso
 */
public class Login {
    
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
    
// Constructor for the login class
    
    public Login() {
        this.username = "";
        this.password = "";
        this.cellPhoneNumber = "";
        this.firstName = "Kyle";
        this.lastName = "";   
    }
 
/**
//Constructor with the users details
 
  @param username The username
  @param password The users Password
  @param cellPhoneNumber The users South African cell phone number
  @param firstName The users first name
  @param lastName The users last name
  */
  public Login(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
      
      this.username = username;
      this.password = password;
      this.cellPhoneNumber = cellPhoneNumber;
      this.firstName = firstName;
      this.lastName = lastName;            
  }
  
  /**
   * Checks if the username is formatted correctly
   * and is not more than five characters long.
   * 
   * @return true if the username is formatted correctly
   */
  public boolean checkUserName() {
      return username.contains("_") && username.length() <=5;
  }
  
  /**
   * Checks if the password meets the required complexity:
   * - At least 8 characters
   * - Contains a capital letter
   * - Contains a number
   * - Contains a special character
   * 
   * @return true if the password meets the requirements
   */
  public boolean checkPasswordComplexity() {
      
      if (password == null || password.length() < 8) {
          return false;
      }
      
      boolean hasCapitalLetter = false;
      boolean hasNumber = false;
      boolean hasSpecialCharacter = false;
      
      for (char character : password.toCharArray()) {
          
          if (Character.isUpperCase(character)) {
              hasCapitalLetter = true;
          }
          if (Character.isDigit(character)) {
              hasNumber = true;
          }
          if (!Character.isLetterOrDigit(character)) {
              hasSpecialCharacter = true;
          }
       }
      return hasCapitalLetter && hasNumber && hasSpecialCharacter;
  } 
  
  /**
   * Checks if the cellphone number:
   * - Starts with the South African international code +27
   * - Contains exactly 9 digits after +27
   * 
   * Example:
   * +27786577904
   * 
   * @return true if the cellphone number is formatted correctly
   */
  public boolean checkCellPhoneNumber() {
      
      String regex = "^\\+27\\d{9}$";
      
      return cellPhoneNumber != null
              && cellPhoneNumber.matches(regex);
  }
  
  /**
   * The user is registered after checking the username and password.
   * 
   * @return You have been logged in successfully!
   */
  public String registerUser() {
      
      if (!checkUserName()) {
          return "Username is not formatted correctly; please ensure that your username contains an underscore and is not more than five characters.";   
      }
      if (!checkPasswordComplexity()) {
          return "Password is not formatted correctly; please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character."; 
      }
      if (!checkCellPhoneNumber()) {
          return "Cell phone number is not formatted correctly or does not contain the correct international code; please correct the number and try again.";   
      }
      return "Username successfully captured.\n"
              + "Password successfully captured.\n"
              + "Cell phone number successfully added.";
  }
  
  /**
   * Checks if the given login details correspond
   * the details stored during registration
   * 
   * @param enteredUserName The user name entered during login
   * @param enteredPassword The password entered during login
   * @return true If the login details correspond
   */
  public boolean loginUser(String enteredUsername, String enteredPassword) {
      
      return username.equals(enteredUsername)
              && password.equals(enteredPassword);
  }
  
  /**
   * Returns a message indicating whether login was successful.
   * 
   * @param loginSuccessful The results of loginUser()
   * @return login status message
   */
  public String returnLoginStatus(boolean loginSuccessful) {
      if (loginSuccessful) {
          return  "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
      } else {
      return "Username or password is incorrect, please try again.";
    }
  }
  
 // Get information
  
  public String getUsername() {
      return username;
  }
  public String getPassword() {
      return password;
  }
  public String getCellPhoneNumber() {
      return cellPhoneNumber;
  }
  public String getFirstName() {
      return firstName;
  }
  public String getLastName() {
      return lastName;
  }
  
  // Setting information
  
  public void setUsername(String username) {
      this.username = username;
  }
  public void setPassword(String password) {
      this.password = password;
  }
  public void setCellPhoneNumber(String cellPhoneNumber) {
      this.cellPhoneNumber = cellPhoneNumber;
  }
  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }
  public void setLastName(String lastName) {
      this.lastName = lastName;
  }
}
  
  