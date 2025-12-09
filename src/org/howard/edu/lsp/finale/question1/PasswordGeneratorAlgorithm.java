package org.howard.edu.lsp.finale.question1;

/**
 * Strategy interface for password generation algorithms.
 * Each concrete implementation provides a different approach
 * to generating passwords.
 */
public interface PasswordGeneratorAlgorithm {
    
    /**
     * Generates a password of the specified length.
     * 
     * @param length the desired password length
     * @return the generated password string
     */
    String generate(int length);
}
