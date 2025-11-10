/**
 * Person.java
 *
 * Author: Guilherme Kologeski
 *
 * This class represents a Person.
 * It serves as a fundamental data model (POJO - Plain Old Java Object)
 * to store and manage basic personal information (name and age).
 *
 * This class demonstrates Encapsulation by keeping its
 * fields 'private' and providing public 'getters' and 'setters'.
 */
public class Person {

    // --- Attributes ---

    /**
     * The person's name.
     * 'private' ensures encapsulation.
     */
    private String name;

    /**
     * The person's age.
     * 'private' ensures encapsulation.
     */
    private int age;

    // --- Constructor ---

    /**
     * Constructs a new Person object.
     * The 'this' keyword is used to distinguish the instance
     * attributes (this.name) from the local parameters (name).
     *
     * @param name The name to assign to this person.
     * @param age  The age to assign to this person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // --- Accessor Methods (Getters) ---

    /**
     * Gets the person's current name.
     *
     * @return The string value of the person's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the person's current age.
     *
     * @return The integer value of the person's age.
     */
    public int getAge() {
        return this.age;
    }

    // --- Mutator Methods (Setters) ---

    /**
     * Sets or updates the person's name.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets or updates the person's age.
     *
     * @param age The new age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    // --- Overridden Methods ---

    /**
     * Overrides the default Object.toString() method.
     * This provides a custom, human-readable string representation
     * of the Person object.
     *
     * @return A formatted string containing the person's name and age.
     */
    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + "Age: " + this.age;
    }
}