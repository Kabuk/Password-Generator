package cz.kuba.passwordgenerator;

import java.util.Random;

/**
 *
 * @author Kuba
 */
public class PasswordGenerator {

    private String password = "";
    private final Random generator = new Random();

    /**
     * Generates password based on parameters
     *
     * @param length length of created password
     * @param upperCase whether uppercase letters should be used
     * @param numbers whether numbers should be used
     *
     * @return generated password
     */
    public String generatePassword(int length, boolean upperCase, boolean numbers) {

        boolean ok = false;

        while (ok == false) {
            password = "";
            boolean upper = false;
            boolean number = false;

            for (int i = 0; i < length; i++) {
                String letter = "";
                boolean correctChar = false;
                while (correctChar == false) {

                    int random = generator.nextInt(127);

                    if (upperCase == true && random > 64 && random < 91) {
                        char character = (char) random;
                        letter = Character.toString(character);
                        upper = true;
                        correctChar = true;
                    }

                    if (numbers == true && random > 47 && random < 58) {
                        char character = (char) random;
                        letter = Character.toString(character);
                        number = true;
                        correctChar = true;
                    }

                    if (random > 96 && random < 123) {
                        char character = (char) random;
                        letter = Character.toString(character);
                        correctChar = true;
                    }

                }
                password += letter;
            }

            ok = (upperCase != true || upper != false) && (numbers != true || number != false) && password.length() == length;
        }
        return password;
    }
}
