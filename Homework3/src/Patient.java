
//--------------------------------------------------------
// Title: Patient Class
// Assignment: 3
// Description: This class represents a patient in a hospital system. Each patient
//// is associated with a doctor, a visit date, and a care team (medical staff members).
//// It implements the Comparable interface to allow sorting by visit date and name.
//--------------------------------------------------------
  public class Patient implements Comparable<Patient> {

      private String firstName;   // Patient's first name
      private String lastName;    // Patient's last name
      private String doctorName;  // Name of the doctor assigned to the patient
      int visitDay, visitMonth, visitYear; // Visit date: day, month, year
      private BST careTeam; // A Binary Search Tree of medical staff members for the patient

      //--------------------------------------------------------
      // Summary: Constructs a new Patient object with the given details.
      // Precondition: firstName, lastName, doctorName are non-null Strings;
      // visitDay, visitMonth, visitYear are valid integers representing the visit date.
      // Postcondition: A Patient object is created with an empty care team.
      //--------------------------------------------------------
      public Patient(String firstName, String lastName, String doctorName, int visitDay, int visitMonth, int visitYear) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.doctorName = doctorName;
          this.visitDay = visitDay;
          this.visitMonth = visitMonth;
          this.visitYear = visitYear;
          this.careTeam = new BST<>();
      }



      //--------------------------------------------------------
      // Summary: Retrieves the full name of the patient.
      // Precondition: None.
      // Postcondition: Returns the concatenation of firstName and lastName separated by a space.
      //--------------------------------------------------------
      public String getName() {
          return firstName + " " + lastName;
      }


      //--------------------------------------------------------
      // Summary: Retrieves the name of the doctor assigned to the patient.
      // Precondition: None.
      // Postcondition: Returns the doctor's name as a String.
      //--------------------------------------------------------
      public String getDoctorName() {
          return doctorName;
      }

      //--------------------------------------------------------
      // Summary: Updates the name of the doctor assigned to the patient.
      // Precondition: doctorName is a non-null String.
      // Postcondition: Updates the doctor's name.
      //--------------------------------------------------------
      public void setDoctorName(String doctorName) {
          this.doctorName = doctorName;
      }

      //--------------------------------------------------------
      // Summary: Retrieves the patient's care team.
      // Precondition: None.
      // Postcondition: Returns the care team as a Binary Search Tree (BST).
      //--------------------------------------------------------
      public BST getCareTeam() {
          return careTeam;
      }

      //--------------------------------------------------------
      // Summary: Sets the patient's care team.
      // Precondition: careTeam is a non-null BST of MedicalStaff objects.
      // Postcondition: Updates the patient's care team.
      //--------------------------------------------------------
      public void setCareTeam(BST careTeam) {
          this.careTeam = careTeam;
      }

      //--------------------------------------------------------
      // Summary: Compares this patient with another patient for ordering.
      // Precondition: other is a non-null Patient object.
      // Postcondition: Returns a negative integer, zero, or a positive integer as this
      // patient's visit date (or name if the dates are the same) is less than, equal to,
      // or greater than the specified patient's visit date (or name).
      //--------------------------------------------------------
      public int compareTo(Patient other) {
          if (this.visitYear != other.visitYear) {
              return Integer.compare(this.visitYear, other.visitYear); // Compare by visit year
          } else {
              return this.getName().compareTo(other.getName()); // Compare by name if years are the same
          }
      }

      //--------------------------------------------------------
      // Summary: Returns a string representation of the patient.
      // Precondition: None.
      // Postcondition: Returns a formatted string containing the patient's first name,
      // last name, visit year, and doctor's name.
      //--------------------------------------------------------
      public String toString() {
          return firstName + " " + lastName + ", " + visitYear + ", " + doctorName;
      }
  }
