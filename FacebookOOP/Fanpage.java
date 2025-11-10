/**
 * Fanpage.java
 *
 * Author: Guilherme Kologeski
 *
 * This class represents a "Fanpage" account, which is a specialized
 * type of "FacebookAccount" (demonstrating Inheritance).
 *
 * It inherits all common methods (getUrl, setPassword, etc.) and
 * adds its own specific attribute and behavior: 'likes'.
 */
public class Fanpage extends FacebookAccount {

    // --- Attributes ---

    /**
     * Stores the count of "likes" for this Fanpage.
     * 'private' ensures it is encapsulated and can only be
     * modified via the public addLike() method.
     */
    private int likes;

    // --- Constructor ---

    /**
     * Constructs a new Fanpage object.
     *
     * @param url      The web address for this account (from parent).
     * @param username The username for this account (from parent).
     * @param password The password for this account (from parent).
     */
    public Fanpage(String url, String username, String password) {
        // 1. CRITICAL: Call the parent (FacebookAccount) constructor
        //    using 'super()' to initialize the inherited fields.
        super(url, username, password);

        // 2. Initialize this class's specific attribute.
        this.likes = 0;
    }

    // --- Accessor Method (Getter) ---

    /**
     * Gets the current number of likes for this page.
     *
     * @return The integer count of likes.
     */
    public int getLikes() {
        return this.likes;
    }

    // --- Core Method (Business Logic)---

    /**
     * Implements the "like" action.
     * This enforces the business rule that likes can only be
     * incremented by 1 (Encapsulation).
     */
    public void addLike() {
        this.likes++;
    }

    // --- Overridden Methods ---

    /**
     * Overrides the parent's toString() method to provide a
     * more specific string representation (Polymorphism).
     *
     * @return A formatted string with all account info PLUS the like count.
     */
    @Override
    public String toString() {
        // 1. Reuse the parent's code via 'super.toString()'
        // 2. Append this class's specific information.
        return super.toString() + "\n" + "Likes: " + this.likes;
    }
}