package org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * Enhanced password generation algorithm that generates passwords
 * containing uppercase letters, lowercase letters, and digits
 * using java.security.SecureRandom for improved security.
 */
public class EnhancedPasswordAlgorithm implements PasswordGeneratorAlgorithm {
    
    private static final String ALLOWED = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "abcdefghijklmnopqrstuvwxyz" +
        "0123456789";
    private final SecureRandom secureRandom;
    
    /**
     * Creates a new EnhancedPasswordAlgorithm instance.
     */
    public EnhancedPasswordAlgorithm() {
        this.secureRandom = new SecureRandom();
    }
    
    /**
     * Generates a password containing uppercase letters, lowercase letters,
     * and digits using SecureRandom.
     * 
     * @param length the desired password length
     * @return a password string containing A-Z, a-z, and 0-9
     */
    @Override
    public String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(ALLOWED.length());
            password.append(ALLOWED.charAt(index));
        }
        return password.toString();
    }
}

