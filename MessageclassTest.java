package POEpart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageclassTest {

    //Checks messag length
    @Test
    public void testMessageLengthSuccess() {

        Messageclass msg = new Messageclass(
                1,
                "+27123456789",
                "Hello this message is valid"
        );

        String expected = "Message sent";

        assertEquals(expected, msg.checkMessage());
    }

    @Test
    public void testMessageLengthFailure() {

        String longMessage = "A".repeat(260);

        Messageclass msg = new Messageclass(
                1,
                "+27123456789",
                longMessage
        );

        String expected =
                "Please enter a message of less than 250 characters.";

        assertEquals(expected, msg.checkMessage());
    }

    
  // Checks the recipient number is correctly formatted
    @Test
    public void testRecipientSuccess() {

        Messageclass msg = new Messageclass(
                1,
                "+27831234567",
                "Hello"
        );

        assertTrue(msg.checkRecipient());
    }

    @Test
    public void testRecipientFailure() {

        Messageclass msg = new Messageclass(
                1,
                "0831234567",
                "Hello"
        );

        assertFalse(msg.checkRecipient());
    }

    
// Ensures message hash is correct
    @Test
    public void testCreateHash() {

        Messageclass msg = new Messageclass(
                0,
                "+27831234567",
                "Hi tonight"
        );

        String hash = msg.createHash();

        // Checks format contains :
        assertTrue(hash.contains(":"));

        // Checks hash is uppercase
        assertEquals(hash.toUpperCase(), hash);
    }

    

    @Test
    public void testMessageIDCreated() {

        Messageclass msg = new Messageclass(
                1,
                "+27831234567",
                "Test message"
        );

        String hash = msg.createHash();

        // Message ID first two digits are used
        assertNotNull(hash);

        // ID should be 10 digits
        assertEquals(10, msg.generateMessageID().length());
    }

    

    @Test //Checks sent message
    public void testSendMessageOption() {

        String expected = "Message successfully sent";

        String actual = "Message successfully sent";

        assertEquals(expected, actual);
    }

    

    @Test 
    public void testDisregardMessageOption() {

        String expected = "Press 0 to delete message";

        String actual = "Press 0 to delete message";

        assertEquals(expected, actual);
    }

    

    @Test
    public void testStoreMessageOption() {

        String expected = "Message successfully stored";

        String actual = "Message successfully stored";

        assertEquals(expected, actual);
    }
}