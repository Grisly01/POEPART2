package POEpart1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Messageclass {
    
// Declaration of variables
private String IDmessage;
private int numMessage;
private String recipent;
private String message;
    
// Constructor to assign values inputed by the user to variables
public Messageclass(int enteredCount, String enteredRecipient, String enteredText, String enteredID) 
{
IDmessage = enteredID;
numMessage = enteredCount;
recipent = enteredRecipient;
message = enteredText;
}
    
// Method to generate the 10 random digit number
public String generateMessageID() {

long randomNumber =
(long) (Math.random() * 9000000000L) + 1000000000L;

return "" + randomNumber;
}
    
// Method to ensure the number has no more than ten characters and contains an international code
public boolean checkRecipient() {

// Starts with + and followed by 10 to 12 digits
String regex = "^\\+[0-9]{10,12}$";

return recipent.matches(regex);
}
     
// Method to ensure that the message is less than 250 characters 
public String checkMessage() {

if (message.length() <= 250) {
return "Message sent";
}

return "Please enter a message of less than 250 characters.";
}
      
// Method to create message Hash
public String createHash() {
           
// Takes the first two numbers of the message ID
String firstTwo = "" + IDmessage.charAt(0) + IDmessage.charAt(1);
                        
// This separates wherever there is space in the message into singular words
String[] words = message.split(" ");
                
// Prevent crash if message is empty
String firstWord = words.length > 0 ? words[0] : "";
String lastWord = words.length > 0 ? words[words.length - 1] : "";        

// Different variables are put together along with the semicolon to create the hash
String hash = firstTwo + ":" + numMessage + ":" + firstWord + lastWord;
  
// Ensures all words to uppercase
return hash.toUpperCase();
}

public String getMessageID() {
return IDmessage;
}
 
// Method that will be called in the main method to display all messages
public static void runProgram() {
 
// Initialising variables
int sentMessages = 0;
int option = 0;
      
Scanner scanner = new Scanner(System.in);

System.out.println("Welcome to QuickChat");

// Asks the user how many messages will be sent
System.out.print("How many messages would you like to send? ");
int totalMessages = scanner.nextInt();
scanner.nextLine();
               
// Loop for menu to be displayed to user
while (option != 3) {
      
System.out.println("Menu");
System.out.println("1. Send Messages");
System.out.println("2. Show recently sent messages");
System.out.println("3. Quit");

System.out.print("Choose an option: ");
option = scanner.nextInt();
scanner.nextLine(); 
      
// information displayed when user picks option 1
if (option == 1) {
      
if (sentMessages < totalMessages) {

System.out.print("Enter message ID: ");
String messageID = scanner.nextLine();

System.out.print("Enter recipient number: ");
String recipient = scanner.nextLine();
       
System.out.print("Enter your message: ");
String text = scanner.nextLine();
       
sentMessages++;
       
// variable messageText that will store messageclass object
Messageclass messageText = new Messageclass(sentMessages, recipient, text, messageID);
       
// if statement to check recipient
if (messageText.checkRecipient()) {
System.out.println("Recipient number is valid"); 
} else {
System.out.println("Recipient number is invalid");
}
            
// Ensures the message is at the correct length
String result = messageText.checkMessage();
System.out.println(result);
    
// Prompts the user on what to do with message
System.out.println("Choose an option:");
System.out.println("1. Send Message");
System.out.println("2. Disregard Message");
System.out.println("3. Store Message");
    
int choice = scanner.nextInt();
scanner.nextLine(); 
    
// Information displayed when option 1 is picked
if (choice == 1) {
   
System.out.println("Message successfully sent");    
    
System.out.println("Message Details");
System.out.println("Message ID: " + messageText.getMessageID());
    
System.out.println("Message Hash: " + messageText.createHash());
    
System.out.println("Recipient: " + recipient);
    
System.out.println("Message: " + text);
}
      
// Information displayed when user deletes message
else if (choice == 2) {
System.out.println("Press 0 to delete message");
}   

// Information displayed when user stores message
else if (choice == 3) {
System.out.println("Message successfully stored");
}
else {
System.out.println("Invalid option");
}
} 
}
    
// Information displayed when option 2 is picked
else if (option == 2) {
System.out.println("Coming Soon.");
}
     
// Information displayed when option 3 is picked
else if (option == 3) {
System.out.println("Total messages sent: " + sentMessages);
System.out.println("Goodbye");    
}
else {
System.out.println("Invalid option");         
}
}

scanner.close(); 
        
}
    
public String storeMessage() {

try {

FileWriter writer = new FileWriter("messages.json", true);

String jsonMessage =
"{\n" +
"\"messageID\":\"" + IDmessage + "\",\n" +
"\"recipient\":\"" + recipent + "\",\n" +
"\"message\":\"" + message + "\"\n" +
"}\n";

writer.write(jsonMessage);

writer.close();

return "Message successfully stored";

} catch (IOException e) {

return "Error storing message";
}
}
} 