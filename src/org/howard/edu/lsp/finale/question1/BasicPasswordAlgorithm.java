package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Basic password generation algorithm that generates passwords
 * containing only digits (0-9) using java.util.Random.
 */
public class BasicPasswordAlgorithm implements PasswordGeneratorAlgorithm {
    
    private static final String DIGITS = "0123456789";
    private final Random random;
    
    /**
     * Creates a new BasicPasswordAlgorithm instance.
     */
    public BasicPasswordAlgorithm() {
        this.random = new Random();
    }
    
    /**
     * Generates a password containing only digits.
     * 
     * @param length the desired password length
     * @return a password string containing only digits (0-9)
     */
    @Override
    public String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(DIGITS.length());
            password.append(DIGITS.charAt(index));
        }
        return password.toString();
    }
}
