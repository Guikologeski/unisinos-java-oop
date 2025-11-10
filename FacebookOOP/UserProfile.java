/**
 * UserProfile.java
 *
 * Author: Guilherme Kologeski
 *
 * This class represents a "User Profile" account, which is another
 * specialized type of "FacebookAccount".
 *
 * This class demonstrates two core OOP principles:
 * 1. **Inheritance**: It 'extends' FacebookAccount (it "IS A" FacebookAccount).
 * 2. **Composition**: It "HAS A" list of 'Person' objects (it "HAS" friends).
 */
public class UserProfile extends FacebookAccount {

    // --- Attributes ---

    /**
     * An array to store Person objects, representing this user's friends.
     * This is an example of Composition.
     */
    private Person[] friends;

    /**
     * A private counter that tracks:
     * 1. The *current number* of friends.
     * 2. The *next available index* for inserting a new friend.
     */
    private int friendCount;

    /**
     * A 'static final' constant defining the maximum capacity of the
     * friends list. Using a constant avoids "magic numbers".
     */
    public static final int MAX_FRIENDS = 1000;

    // --- Constructor ---

    /**
     * Constructs a new UserProfile object.
     *
     * @param url      The web address for this account (from parent).
     * @param username The username for this account (from parent).
     * @param password The password for this account (from parent).
     */
    public UserProfile(String url, String username, String password) {
        // 1. Call the parent (FacebookAccount) constructor
        super(url, username, password);

        // 2. Initialize the 'friends' array with its maximum capacity.
        this.friends = new Person[MAX_FRIENDS];

        // 3. Initialize the friend counter to 0.
        this.friendCount = 0;
    }

    // --- Accessor Method (Getter) ---

    /**
     * Gets the current number of friends this user has.
     *
     * @return The integer count of friends.
     */
    public int getFriendCount() {
        return this.friendCount;
    }

    // --- Core Method (Business Logic) ---

    /**
     * Adds a new 'Person' object to the user's friends list.
     *
     * @param friendToAdd The Person object to be added.
     * @return 'true' if the friend was successfully added,
     * 'false' if the friends list is full.
     */
    public boolean addFriend(Person friendToAdd) {
        // 1. "Guard Clause": Check if the friends list is full.
        if (friendCount >= MAX_FRIENDS) {
            return false; // Return failure
        }

        // 2. Add the new friend at the next available index
        this.friends[this.friendCount] = friendToAdd;

        // 3. Increment the counter
        this.friendCount++;

        return true; // Return success
    }

    // --- Overridden Methods ---

    /**
     * Overrides the parent's toString() method.
     *
     * @return A formatted string with account info AND friend count.
     */
    @Override
    public String toString() {
        // 1. Reuse the parent's toString() output
        // 2. Append this class's specific information
        return super.toString() + "\n" + "[Friends: " + this.friendCount + "]";
    }
}