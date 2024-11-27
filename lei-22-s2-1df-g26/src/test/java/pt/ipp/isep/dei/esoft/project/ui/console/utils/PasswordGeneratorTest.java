package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordGeneratorTest {

    @Test
    void generatePassword() {
        for (int i = 0; i < 100; i++){
            String pass = PasswordGenerator.generatePassword();
            System.out.println(pass + " " + "Size: " + pass.length());
            assertTrue(pass.length() >= 8);
            assertTrue(pass.matches(".*\\d.*\\d.*"));
            assertTrue(pass.matches(".*[A-Z].*[A-Z].*[A-Z].*"));
        }
    }
}