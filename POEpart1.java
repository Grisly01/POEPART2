/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package POEpart1;
import java.util.Scanner;

public class POEpart1 {

    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        
        //Declaration
        String username = "";
        String password = "";
        String number = "";
          
        int attempts = 0;
        boolean isRegistered = false;
        
//loop for registration phase to be repeated if user inputs wrong details
        while (attempts < 5 && !isRegistered) {

    // Registration 
    System.out.println("Enter your name");
    String name = scanner.nextLine();
             
  System.out.println("What is your surname");
   String surname = scanner.nextLine();
             
    System.out.println("Enter your username");
   username = scanner.nextLine();
            
    System.out.println("Enter your password");
   password = scanner.nextLine();
            
    System.out.println("Enter your South African number");
   number  = scanner.nextLine();

            // methods from loginclass being called and assigned to variables
            boolean userNameValid = Loginclass.checkUserName(username);
            boolean passWordValid = Loginclass.checkPasswordComplexity(password);
            boolean phoneNumberValid = Loginclass.checkCellPhoneNumber(number);

            // if statement to validate username
            if (userNameValid){
                System.out.println("Username successfully captured");
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length");
            }   

            // if statements to validate password
            if (passWordValid){
                System.out.println("Password successfully captured");
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");   
            }  

            // if statements to validate cell phone number
            if (phoneNumberValid){
                System.out.println("Cell phone number successfully added");
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }

            // If statements to allow user to login if all registration conditions are met
            if (userNameValid && passWordValid && phoneNumberValid) {
                isRegistered = true;

                int loginAttempts = 0;
                boolean isLoggedIn = false;

                //loop for lor login phase if user inputs wrong password or username, user will be asked to try again
                while (loginAttempts < 3 && !isLoggedIn) {

                    System.out.println("Enter your username to login");
                    String loginUsername = scanner.nextLine();

                    System.out.println("Enter your password to login");
                    String loginPassword = scanner.nextLine();

                    //method from Loginclass being called and assigned a variable,it is used in method loginUserValid in loginclass
                    boolean loginUserValid = Loginclass.loginUser(username, password, loginUsername, loginPassword);

                    //method from Loginclass being called and assigned a variable to show message after input of login deatils
                    String message = Loginclass.returnLoginStatus(
                        username, password, loginUsername, loginPassword, name, surname
                    );

                    System.out.println(message);

                    if (message.startsWith("Welcome")) {
                        isLoggedIn = true;
                        
                        System.out.println("Login successful!"); 
                        
                        Messageclass.runProgram();

                    } else {
                        loginAttempts++;
                        
                        //limit of loop is 3 and loop breaks once limit is exceeded
                        if (loginAttempts == 3) {
                            System.out.println("Too many failed login attempts.");
                        } else {
                            System.out.println("Please try again.");
                        }
                    }
                }

            } else {
                attempts++;

                if (attempts == 5) {
                    System.out.println("Maximum attempts of 5 reached. Registration failed.");
                } else {
                    System.out.println("Please try again.");
                }
            }
        }
        
        scanner.close();
    }
}