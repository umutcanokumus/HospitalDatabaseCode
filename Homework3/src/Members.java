//--------------------------------------------------------
// Title: Members Class
// Author:Umutcan OKUMUŞ
// ID: 43057338238
// Section: 02
// Assignment: 3
// Description: This class represents a medical staff member (Member) associated
//// with a patient. It stores the member's first name, last name, and role, and
//// implements the Comparable interface for sorting by name.
////--------------------------------------------------------
public class Members implements Comparable<Members> {
    private String firstName; // Member's first name
    private String lastName;  // Member's last name
    private String role;      // Member's role (e.g., Doctor, Nurse)

    //--------------------------------------------------------
    // Constructs a new Members object with the given details.
    // Precondition: firstName, lastName, and role are non-null Strings.
    // Postcondition: A Members object is created with the specified details.
    //--------------------------------------------------------
    public Members(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }




    //--------------------------------------------------------
    // Retrieves the member's role.
    // Precondition: None.
    // Postcondition: Returns the role as a String.
    //--------------------------------------------------------
    public String getRole() {
        return role;
    }

    //--------------------------------------------------------
    // Updates the member's role.
    // Precondition: role is a non-null String.
    // Postcondition: Updates the member's role.
    //--------------------------------------------------------
    public void setRole(String role) {
        this.role = role;
    }

    //--------------------------------------------------------
    // Retrieves the full name of the member.
    // Precondition: None.
    // Postcondition: Returns the concatenation of firstName and lastName separated by a space.
    //--------------------------------------------------------
    public String getName() {
        return firstName + " " + lastName;
    }

    //--------------------------------------------------------
    // Compares this member with another member for ordering.
    // Precondition: other is a non-null Members object.
    // Postcondition: Returns a negative integer, zero, or a positive integer as this
    // member's name is less than, equal to, or greater than the specified member's name.
    //--------------------------------------------------------
    public int compareTo(Members other) {
        return this.getName().compareTo(other.getName());
    }

    //--------------------------------------------------------
    // Returns a string representation of the member.
    // Precondition: None.
    // Postcondition: Returns a formatted string containing the member's first name,
    // last name, and role.
    //--------------------------------------------------------
    public String toString() {
        return firstName + " " + lastName + ", " + role;
    }
}