package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generatePassword() {
        int passwordLength = 8; // Desired password length
        int numDigits = 2; // Number of digits
        int numCaps = 3; // Number of capital letters

        Random rand = new Random();
        List<Character> passwordChars = new ArrayList<>();
        int countDigits = 0;
        int countCaps = 0;

        // Add exactly 3 capital letters
        while (countCaps < numCaps) {
            char nextChar = (char) (rand.nextInt(26) + 'A');
            passwordChars.add(nextChar);
            countCaps++;
        }

        // Add exactly 2 digits
        while (countDigits < numDigits) {
            passwordChars.add((char) (rand.nextInt(10) + '0'));
            countDigits++;
        }

        // Fill remaining characters with lowercase letters
        for (int i = passwordChars.size(); i < passwordLength; i++) {
            char nextChar = ALPHA_NUMERIC_STRING.charAt(rand.nextInt(ALPHA_NUMERIC_STRING.length()));
            passwordChars.add(nextChar);
        }

        // Shuffle the characters in the password
        Collections.shuffle(passwordChars);

        // Convert the list of characters to a string and return it
        StringBuilder password = new StringBuilder();
        //for (int i = 0; i < passwordChars.size(); i++) {
        //    char c = passwordChars.get(i);
        //    password.append(c);
        //}
        for (char c : passwordChars) { // for each iterating over EACH element of the char List
            // (char c points to the current element)
            password.append(c);
        }
        return password.toString();
    }
}

