import java.util.Scanner;

/**
 * Main.java
 *
 * Author: Guilherme Kologeski
 *
 * This is the main driver class for the application.
 * It contains the 'main' method, which serves as the entry point.
 *
 * This class simulates the entire Facebook system by:
 * 1. Initializing the main 'Facebook' container.
 * 2. Populating it with different account types (polymorphically).
 * 3. Testing the system's boundary conditions (e.g., full capacity).
 * 4. Executing and testing the methods of all other classes.
 */
public class Main {

    /**
     * The main entry point for the Java application.
     *
     * @param args Command-line arguments (not used in this project).
     */
    public static void main(String[] args) {

        // --- 0. System Initialization ---
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Facebook System Boot ---");
        System.out.print("Enter account capacity for Facebook: ");
        int capacity = scanner.nextInt();

        // CRITICAL: Consume the leftover newline character ('\n')
        // This is required after nextInt() before a nextLine()
        scanner.nextLine();

        // Create the main database/manager object
        Facebook myFacebook = new Facebook(capacity);

        // --- 1. Populate Database (Stress Test) ---
        System.out.println("Attempting to insert " + (capacity + 3) + " accounts (testing limit)...");

        // This loop intentionally tries to add 3 *more* accounts
        // than the capacity to test the 'addAccount' boundary.
        for (int i = 0; i < (capacity + 3); i++) {

            // Generate mock data
            String url = "facebook.com/user" + i;
            String user = "user" + i;
            String pass = "123";

            int type = (int) (Math.random() * 2); // 0 or 1

            // --- POLYMORPHISM IN ACTION ---
            // Declare a variable of the *parent* type
            FacebookAccount newAccount;

            // Instantiate a *child* class
            if (type == 1) {
                newAccount = new Fanpage(url, user, pass);
            } else {
                newAccount = new UserProfile(url, user, pass);
            }

            // Add the account (polymorphically)
            boolean success = myFacebook.addAccount(newAccount);

            if (success) {
                System.out.println("    Attempt " + (i + 1) + ": " + user + " (Type " + type + ") inserted successfully.");
            } else {
                System.out.println("    Attempt " + (i + 1) + ": " + user + " FAILED. (Facebook is full).");
            }
        }

        // --- 2. Print All Account Information (Polymorphism Test) ---
        System.out.println("\n--- All Account Information ---");
        myFacebook.printAllAccountInfo();

        // --- 3. Print Fanpage-Specific URLs (Runtime Type Check Test) ---
        System.out.println("\n--- All Fanpage URLs ---");
        myFacebook.printAllFanpageUrls();

        // --- 4. Add Friends (Composition and Down-casting Test) ---
        System.out.println("\n--- Adding Random Friends to Users ---");

        FacebookAccount[] accounts = myFacebook.getAllAccounts();
        int realAccountCount = myFacebook.getAccountCount();

        // Loop only over the *active* accounts
        for (int i = 0; i < realAccountCount; i++) {

            // Check if the current object is a 'UserProfile'
            if (accounts[i] instanceof UserProfile) {
                
                // --- DOWN-CASTING ---
                // We must cast 'accounts[i]' to 'UserProfile' to
                // access the 'addFriend()' method, which only
                // exists on the 'UserProfile' class.
                UserProfile u = (UserProfile) accounts[i];

                // Generate a random number of friends (1 to 10)
                int friendCount = (int) (Math.random() * 10) + 1;
                System.out.println("-> Adding " + friendCount + " friends to user: " + u.getUsername());

                for (int j = 0; j < friendCount; j++) {
                    // Create a new Person object
                    Person friend = new Person("Friend_" + j, 25);

                    // Try to add the friend
                    boolean friendSuccess = u.addFriend(friend);

                    if (!friendSuccess) {
                        System.out.println("    -> Failed to add Friend_" + j + " (Friend limit [" + UserProfile.MAX_FRIENDS + "] reached).");
                    }
                }
            }
        }

        // --- 5. Test Secure Password Change ---
        System.out.println("\n--- Change Password ---");
        System.out.print("Enter username to change password: ");
        String searchUser = scanner.nextLine();

        System.out.print("Enter the NEW password for " + searchUser + ": ");
        String newPassword = scanner.nextLine();

        boolean userFound = false;
        for (int i = 0; i < realAccountCount; i++) {
            // Find the user by their username
            if (accounts[i].getUsername().equals(searchUser)) {
                userFound = true;
                
                // Call the secure password setter
                // This will trigger the prompt for the *old* password
                accounts[i].setPassword(newPassword);
                
                break; // Stop looping once found
            }
        }

        if (!userFound) {
            System.out.println("    [FAILURE] User '" + searchUser + "' not found.");
        }

        // --- 6. Cleanup Resources ---
        System.out.println("\n--- End of Execution ---");
        // Always close the scanner
        scanner.close();
    }
}