package org.howard.edu.lsp.finale.question1;

/**
 * Singleton service for generating passwords using various algorithms.
 * This service provides a centralized point of access for password generation
 * and allows runtime selection of password generation strategies.
 * 
 * DESIGN PATTERN DOCUMENTATION:
 * 
 * Pattern(s) Used:
 * 1. Singleton Pattern - Ensures only one instance of PasswordGeneratorService exists
 * 2. Strategy Pattern - Encapsulates different password generation algorithms
 * 
 * Justification:
 * 
 * Singleton Pattern:
 * - Requirement #5 states "Provide a single shared access point"
 * - The exam explicitly requires "Only one instance of the service may exist"
 * - Ensures consistent state management across the application
 * - Provides global point of access via getInstance()
 * 
 * Strategy Pattern:
 * - Requirement #1: "Support multiple approaches to password generation"
 * - Requirement #2: "Allow the caller to select the approach at run time"
 * - Requirement #4: "Make password-generation behavior swappable"
 * - Requirement #3: "Support future expansion" - new algorithms can be added
 *   without modifying existing code (Open/Closed Principle)
 * - Each algorithm is encapsulated in its own strategy class
 * - Algorithms can be switched at runtime via setAlgorithm()
 * - Client code remains unchanged when new algorithms are added
 */
public class PasswordGeneratorService {
    
    private static PasswordGeneratorService instance;
    private PasswordGeneratorAlgorithm currentAlgorithm;
    
    /**
     * Private constructor to prevent direct instantiation.
     * Enforces Singleton pattern.
     */
    private PasswordGeneratorService() {
        // Private constructor for singleton
    }
    
    /**
     * Returns the single instance of PasswordGeneratorService.
     * Creates the instance on first call (lazy initialization).
     * 
     * @return the singleton instance
     */
    public static PasswordGeneratorService getInstance() {
        if (instance == null) {
            instance = new PasswordGeneratorService();
        }
        return instance;
    }
    
    /**
     * Sets the password generation algorithm to use.
     * 
     * @param name the algorithm name ("basic", "enhanced", or "letters")
     * @throws IllegalArgumentException if algorithm name is not recognized
     */
    public void setAlgorithm(String name) {
        switch (name.toLowerCase()) {
            case "basic":
                currentAlgorithm = new BasicPasswordAlgorithm();
                break;
            case "enhanced":
                currentAlgorithm = new EnhancedPasswordAlgorithm();
                break;
            case "letters":
                currentAlgorithm = new LettersPasswordAlgorithm();
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + name);
        }
    }
    
    /**
     * Generates a password of the specified length using the currently
     * selected algorithm.
     * 
     * @param length the desired password length
     * @return the generated password
     * @throws IllegalStateException if no algorithm has been set
     */
    public String generatePassword(int length) {
        if (currentAlgorithm == null) {
            throw new IllegalStateException("Algorithm not set. Call setAlgorithm() first.");
        }
        return currentAlgorithm.generate(length);
    }
}