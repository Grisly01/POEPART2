/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package POEpart1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class POEpart1Test {
    
    public POEpart1Test() {
    }
 String firstName ="Ofentse";
 String lastName = "Molefe";
 
     @Test
     //correct conditions used
    public void testCheckUserName() {
        assertTrue(Loginclass.checkUserName("kyl_1"));
    System.out.println("Welcom"+firstName+lastName+"it is great to see you");}
    
     @Test
     //wrong conditions used
    public void testcheckUserName() {
        assertFalse(Loginclass.checkUserName("kyle!!!!!!!"));
   System.out.println("Username is not correctly formatted,please ensure your username contains an underscore and is no more than five characters in length"); }

    @Test
    //correct conditions used
    public void testCheckPasswordComplexity() {
        assertTrue(Loginclass.checkPasswordComplexity("Ch&&sec@ke99!"));
   System.out.println("Password successfully captured"); }

    @Test
    //correct conditions not used
    public void testcheckPasswordComplexity() {
        assertFalse(Loginclass.checkPasswordComplexity("password"));
   System.out.println("Password is not correctly formatted,please ensure the password contains atleast eight characters, a capital,a number and a special character."); }

    @Test
    //international code used
    public void testCheckCellPhoneNumber() {
        assertTrue(Loginclass.checkCellPhoneNumber("+27838968976"));
    System.out.println("Cell number successfully captured");}

    @Test
    //no international code used
    public void testcheckCellPhoneNumber() {
        assertFalse(Loginclass.checkCellPhoneNumber("089665583"));
    System.out.println("Cell number is incorrectly formatted or does not contain an international code;please correct the number and try again");}
    
    @Test
    //Correct login details
    public void testLogin() {
        assertTrue(Loginclass.loginUser(
                "kyl_1", "Ch&&sec@ke99!",
                "kyl_1", "Ch&&sec@ke99!"
        ));
   System.out.println("Welcom"+firstName+lastName+"it is great to see you"); }

    @Test
    //Wrong password 
    public void testLoginWrongPassword() {
        assertFalse(Loginclass.loginUser(
                "kyl_1", "Ch&&sec@ke99!",
                "kyl_1", "WrongPass1!"
        ));
System.out.println("username or password incorrect please try again");}
}
