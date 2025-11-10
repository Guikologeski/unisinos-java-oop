import java.util.Scanner;

/**
 * FacebookAccount.java
 *
 * Author: Guilherme Kologeski
 *
 * This class serves as the "parent" or "superclass" for all Facebook
 * account types (e.g., Fanpage, UserProfile). It defines the common
 * attributes and behaviors that all accounts share (Inheritance).
 *
 * It manages core account data (URL, username, password) and
 * enforces Encapsulation by keeping fields private.
 */
public class FacebookAccount {

    // --- Attributes ---

    private String url;
    private String username;
    private String password;

    /**
     * A single, static Scanner instance to read user input from the console.
     * 'static' means this instance is shared across all objects of this
     * class, preventing resource leaks from opening multiple scanners.
     */
    private static Scanner scanner = new Scanner(System.in);

    // --- Constructor ---

    /**
     * Constructs a new FacebookAccount object.
     *
     * @param url      The web address for this account (e.g., "/my-page").
     * @param username The username for logging in.
     * @param password The password for logging in.
     */
    public FacebookAccount(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // --- Accessor Methods (Getters) ---

    /**
     * Gets the account's URL.
     *
     * @return The string representation of the URL.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Gets the account's username.
     *
     * @return The string representation of the username.
     */
    public String getUsername() {
        return this.username;
    }

    // --- Mutator Methods (Setters) ---

    /**
     * Sets or updates the account's URL.
     *
     * @param url The new URL string to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Sets or updates the account's username.
     *
     * @param username The new username string to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Securely updates the account's password.
     * This method implements business logic by requiring the user
     * to validate their *old* password before the change is applied.
     *
     * @param newPassword The new password to set if validation passes.
     */
    public void setPassword(String newPassword) {
        // 1. Prompt for verification
        System.out.println("To change password for '" + this.username + "', please enter your OLD password:");
        
        // 2. Read input
        String oldPasswordInput = scanner.nextLine();

        // 3. Validate and apply change
        // (Use .equals() for string comparison, NOT '==')
        if (oldPasswordInput.equals(this.password)) {
            this.password = newPassword;
            System.out.println("  [SUCCESS] Password has been changed for " + this.username);
        } else {
            System.out.println("  [FAILURE] Old password incorrect. Password was NOT changed.");
        }
    }

    // --- Overridden Methods ---

    /**
     * Overrides the default Object.toString() method.
     *
     * @return A formatted string with key account details.
     */
    @Override
    public String toString() {
        // This line dynamically gets the class name (e.g., "Fanpage" or "UserProfile")
        // This is a powerful demonstration of Polymorphism.
        // Note: The password is intentionally *not* included.
        return "Account Type: " + this.getClass().getSimpleName() + "\n" +
               "Username: " + this.username + "\n" +
               "URL: " + this.url;
    }
}