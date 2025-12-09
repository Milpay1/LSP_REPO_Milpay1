package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Letters-only password generation algorithm that generates passwords
 * containing only uppercase and lowercase letters (A-Z, a-z).
 */
public class LettersPasswordAlgorithm implements PasswordGeneratorAlgorithm {
    
    private static final String LETTERS = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "abcdefghijklmnopqrstuvwxyz";
    private final Random random;
    
    /**
     * Creates a new LettersPasswordAlgorithm instance.
     */
    public LettersPasswordAlgorithm() {
        this.random = new Random();
    }
    
    /**
     * Generates a password containing only letters.
     * 
     * @param length the desired password length
     * @return a password string containing only A-Z and a-z
     */
    @Override
    public String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(LETTERS.length());
            password.append(LETTERS.charAt(index));
        }
        return password.toString();
    }
}
