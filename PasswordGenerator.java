import java.security.SecureRandom;

public class PasswordGenerator {

    // Define the character sets to be used in the password
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";

    private SecureRandom random = new SecureRandom();

    // Method to generate a random password
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialCharacters) {
        if (length < 1) {
            throw new IllegalArgumentException("Password length must be greater than 0.");
        }

        // Build the character pool based on user preferences
        StringBuilder characterPool = new StringBuilder();

        if (includeUppercase) {
            characterPool.append(UPPERCASE);
        }
        if (includeLowercase) {
            characterPool.append(LOWERCASE);
        }
        if (includeDigits) {
            characterPool.append(DIGITS);
        }
        if (includeSpecialCharacters) {
            characterPool.append(SPECIAL_CHARACTERS);
        }

        // Check if character pool is empty
        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("No character types selected. Please select at least one character type.");
        }

        // Generate the password from the selected character pool
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }

        return password.toString();
    }
}
