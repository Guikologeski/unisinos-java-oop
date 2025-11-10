# Java OOP: Social Media Account System

This project is a complete Java application that demonstrates core Object-Oriented Programming (OOP) principles. It is based on a university assignment that was refactored with professional naming conventions (English) and full Javadoc-style documentation.

The system simulates a basic social media database (`Facebook`) that can manage different types of accounts (`FacebookAccount`), specifically `Fanpage` and `UserProfile` objects.

---

## Core OOP Principles Demonstrated

This project serves as a practical portfolio piece showcasing the 4 pillars of OOP:

### 1. Inheritance
* A base "superclass" (`FacebookAccount`) defines common attributes (URL, username, password) and methods (`setPassword`).
* Two "child classes" (`Fanpage` and `UserProfile`) **extend** `FacebookAccount`, inheriting its logic and adding their own specific features (e.g., `likes` and `friends`).

### 2. Encapsulation
* All class attributes (fields) are `private` to protect data integrity.
* Data is accessed and modified *only* through public `getter` and `setter` methods.
* **Business logic** is enforced within these methods (e.g., `setPassword` requires old password validation; `addLike` only increments by 1).

### 3. Polymorphism
* The main `Facebook` class manages a single array (`FacebookAccount[]`) that holds **both** `Fanpage` and `UserProfile` objects.
* The `printAllAccountInfo()` method calls the `.toString()` method on each object, and the correct (overridden) version from either `Fanpage` or `UserProfile` is executed at runtime.
* The `main` class uses `instanceof` to perform runtime type checking (e.g., `if (account instanceof UserProfile)`).

### 4. Composition
* The project demonstrates the "HAS-A" relationship:
    * The `Facebook` class *has* an array of `FacebookAccount` objects.
    * The `UserProfile` class *has* an array of `Person` objects.

---

## Classes Included

This project is composed of 6 classes:

1.  **`FacebookAccount.java`**: The parent superclass.
2.  **`Fanpage.java`**: The child class for fanpages.
3.  **`UserProfile.java`**: The child class for user profiles.
4.  **`Person.java`**: The data class used by `UserProfile` for its friends list.
5.  **`Facebook.java`**: The main "container" class that manages the `FacebookAccount[]` array.
6.  **`Main.java`**: The driver class with the `main()` method to run and test the system.
