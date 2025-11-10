/**
 * Facebook.java
 *
 * Author: Guilherme Kologeski
 *
 * This class acts as the main container or "database" for the
 * application. It manages a collection of all 'FacebookAccount'
 * objects (demonstrating Composition).
 *
 * It heavily utilizes **Polymorphism**, as its main array
 * ('allAccounts') can store any object that 'is a' FacebookAccount
 * (e.g., Fanpage, UserProfile) and interact with them dynamically.
 */
public class Facebook {

    // --- Attributes ---

    /**
     * The core data structure. This array holds all 'FacebookAccount'
     * objects. By using the *parent* class type, this array can
     * polymorphically store any of its *child* classes.
     */
    private FacebookAccount[] allAccounts;

    /**
     * Tracks the current number of accounts stored in the
     * 'allAccounts' array. It also serves as the index
     * for the next empty slot.
     */
    private int accountCount;

    // --- Constructor ---

    /**
     * Constructs a new Facebook management object.
     *
     * @param accountCapacity The *maximum capacity* of accounts
     * this Facebook instance can hold.
     */
    public Facebook(int accountCapacity) {
        // 1. Allocates memory for the array
        this.allAccounts = new FacebookAccount[accountCapacity];

        // 2. Initialize the counter to 0
        this.accountCount = 0;
    }

    // --- Core Methods ---

    /**
     * Adds a new 'FacebookAccount' (or any of its subclasses)
     * to the main account list.
     *
     * @param account The polymorphic account object (e.g., a Fanpage
     * or UserProfile instance) to be added.
     * @return 'true' if the account was added, 'false' if the
     * database is full.
     */
    public boolean addAccount(FacebookAccount account) {
        // 1. "Guard Clause": Check if the array is full.
        if (this.accountCount >= this.allAccounts.length) {
            return false; // Failure: database is full
        }

        // 2. Insert the account at the next available slot
        this.allAccounts[accountCount] = account;

        // 3. Increment the counter
        this.accountCount++;

        return true; // Success
    }

    // --- Accessor Methods (Getters) ---

    /**
     * Gets the raw internal array of all accounts.
     *
     * @return The array of FacebookAccount objects.
     */
    public FacebookAccount[] getAllAccounts() {
        return this.allAccounts;
    }

    /**
     * Gets the current number of *active* accounts.
     *
     * @return The integer count of accounts.
     */
    public int getAccountCount() {
        return this.accountCount;
    }

    // --- Reporting Methods ---

    /**
     * Iterates through all active accounts and prints their
     * information to the console.
     *
     * This method is a key demonstration of **Polymorphism**:
     * It automatically executes the correct '.toString()' method
     * (e.g., Fanpage.toString() or UserProfile.toString())
     * for each object at runtime.
     */
    public void printAllAccountInfo() {
        // Loop only up to 'accountCount' to avoid NullPointerExceptions
        for (int i = 0; i < this.accountCount; i++) {
            FacebookAccount currentAccount = this.allAccounts[i];
            
            // This line implicitly calls currentAccount.toString()
            System.out.println(currentAccount);
        }
    }

    /**
     * Iterates through all active accounts, identifies *only* the
     * 'Fanpage' objects, and prints their URLs.
     *
     * This demonstrates runtime type checking using 'instanceof'.
     */
    public void printAllFanpageUrls() {
        for (int i = 0; i < this.accountCount; i++) {
            FacebookAccount currentAccount = this.allAccounts[i];

            // 1. Use 'instanceof' to check the *actual* class
            if (currentAccount instanceof Fanpage) {
                // 2. If it is a Fanpage, print its URL.
                System.out.println(currentAccount.getUrl());
            }
            // If it's a 'UserProfile' or other type, it is skipped.
        }
    }
}