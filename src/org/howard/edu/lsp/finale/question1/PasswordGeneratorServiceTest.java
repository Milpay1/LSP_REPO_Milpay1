package org.howard.edu.lsp.finale.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test suite for PasswordGeneratorService.
 * Tests singleton behavior, algorithm functionality, and password generation.
 */
public class PasswordGeneratorServiceTest {
    
    private PasswordGeneratorService service;
    
    /**
     * Sets up the test fixture before each test method.
     * Retrieves the singleton instance of PasswordGeneratorService.
     */
    @BeforeEach
    public void setup() {
        service = PasswordGeneratorService.getInstance();
    }
    
    /**
     * Verifies that getInstance() returns a non-null instance.
     */
    @Test
    public void checkInstanceNotNull() {
        assertNotNull(service, "Service instance should not be null");
    }
    
    /**
     * Verifies true singleton behavior - that getInstance() always
     * returns the exact same object instance in memory.
     */
    @Test
    public void checkSingleInstanceBehavior() {
        PasswordGeneratorService second = PasswordGeneratorService.getInstance();
        assertSame(service, second, 
            "Both references must point to the exact same instance");
    }
    
    /**
     * Verifies that calling generatePassword() without setting an algorithm
     * throws IllegalStateException.
     */
    @Test
    public void generateWithoutSettingAlgorithmThrowsException() {
        PasswordGeneratorService s = PasswordGeneratorService.getInstance();
        assertThrows(IllegalStateException.class, () -> {
            s.generatePassword(10);
        }, "Should throw IllegalStateException when no algorithm is set");
    }
    
    /**
     * Verifies that the basic algorithm generates passwords of correct length
     * containing only digits (0-9).
     */
    @Test
    public void basicAlgorithmGeneratesCorrectLengthAndDigitsOnly() {
        service.setAlgorithm("basic");
        String p = service.generatePassword(10);
        
        assertEquals(10, p.length(), "Password should be 10 characters long");
        assertTrue(p.matches("[0-9]+"), 
            "Password should contain only digits (0-9)");
    }
    
    /**
     * Verifies that the enhanced algorithm generates passwords of correct length
     * containing alphanumeric characters (A-Z, a-z, 0-9).
     */
    @Test
    public void enhancedAlgorithmGeneratesCorrectCharactersAndLength() {
        service.setAlgorithm("enhanced");
        String p = service.generatePassword(12);
        
        assertEquals(12, p.length(), "Password should be 12 characters long");
        assertTrue(p.matches("[A-Za-z0-9]+"), 
            "Password should contain only alphanumeric characters");
    }
    
    /**
     * Verifies that the letters algorithm generates passwords containing
     * only letters (A-Z, a-z).
     */
    @Test
    public void lettersAlgorithmGeneratesLettersOnly() {
        service.setAlgorithm("letters");
        String p = service.generatePassword(8);
        
        assertEquals(8, p.length(), "Password should be 8 characters long");
        assertTrue(p.matches("[A-Za-z]+"), 
            "Password should contain only letters (A-Z, a-z)");
    }
    
    /**
     * Verifies that switching algorithms changes the password generation behavior
     * and that each algorithm produces passwords with the correct characteristics.
     */
    @Test
    public void switchingAlgorithmsChangesBehavior() {
        service.setAlgorithm("basic");
        String p1 = service.generatePassword(10);
        
        service.setAlgorithm("letters");
        String p2 = service.generatePassword(10);
        
        service.setAlgorithm("enhanced");
        String p3 = service.generatePassword(10);
        
        // Verify basic algorithm produces digits only
        assertTrue(p1.matches("[0-9]+"), 
            "Basic algorithm should produce digits only");
        
        // Verify letters algorithm produces letters only
        assertTrue(p2.matches("[A-Za-z]+"), 
            "Letters algorithm should produce letters only");
        
        // Verify enhanced algorithm produces alphanumeric
        assertTrue(p3.matches("[A-Za-z0-9]+"), 
            "Enhanced algorithm should produce alphanumeric characters");
        
        // Verify all have correct length
        assertEquals(10, p1.length());
        assertEquals(10, p2.length());
        assertEquals(10, p3.length());
    }
}
