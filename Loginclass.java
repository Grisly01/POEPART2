/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POEpart1;
 
public class Loginclass { 

       
    //This method ensures that any username contains an underscore and is no more than 5 letters  
 static boolean checkUserName(String username) { 
  return  username.contains("_") && username.length() <= 5;} 

 //This method ensures that passwords meet the following password complexity rules
 static boolean checkPasswordComplexity(String password) { 
 
     if (password.length()<8){
  return false;//Password check stops if password is too short   
     }       
   
    boolean hasUpper = false; 
    boolean hasDigit = false; 
    boolean hasSpecial = false; 
 
    //lopps goes through each character 
    for (char character : password.toCharArray()) { 
      //if statements checks the password complexity
        if (Character.isUpperCase(character)) hasUpper = true; 
        if (Character.isDigit(character)) hasDigit = true; 
        if (!Character.isLetterOrDigit(character)) hasSpecial = true; 
    } 
   return  password.length() >= 8 && hasUpper && hasDigit && hasSpecial;}
 
    static boolean checkCellPhoneNumber(String number) {

    // Checks cell phone number starts with +27
    if (!number.startsWith("+27")) {
        return false;
    }

    // Check total length (+27 + 9 digits = 12 characters)
    if (number.length() != 12) {
        return false;
    }

    // Check that everything after +27 is a digit
    for (int i = 3; i < number.length(); i++) {
        if (!Character.isDigit(number.charAt(i))) {
            return false;
        }
   
    }
   return true; } 

    //Method to check if Login details are the same as Registration details
static boolean loginUser(String username, String password,
                         String loginUsername, String loginPassword) {
    return username.equals(loginUsername) && password.equals(loginPassword);
    }

//Method to display message about login successful or unsuccessful
static String returnLoginStatus(String username, String password,
                                String loginUsername, String loginPassword,
                                String name, String surname) {

    if (loginUser(username, password, loginUsername, loginPassword)) {
        return "Welcome " + name + " " + surname + ", it is great to see you";
    } else {
        return "Username or password incorrect";
    }
}
}

 
 
 
 
 
 
 
 
 
 

