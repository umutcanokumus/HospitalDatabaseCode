//--------------------------------------------------------
// Title: Binary Search Tree (BST) Class
// Assignment: 3
// Description: This class implements a generic Binary Search Tree (BST) where
// values are stored in a sorted manner. It provides methods to add, retrieve,
// delete, and traverse nodes in ascending and descending orders.
//--------------------------------------------------------

public class Main {
    //--------------------------------------------------------
    // Summary: The main method executes a series of operations
    // on a HospitalDatabase object to demonstrate its capabilities.
    // Precondition: None
    // Postcondition: Various operations are performed on the
    // HospitalDatabase instance and their results are printed
    // to the console.
    //--------------------------------------------------------
    public static void main(String[] args) {
        HospitalDatabase hd = new HospitalDatabase();

        System.out.println("---none---");
        System.out.println(" ");

        // Adding patients to the hospital database
        hd.addPatient("Michael Johnson", "Emma Thompson", 19, 12, 2022);
        hd.addPatient("Ethan Lee", "Olivia Sanchez", 8, 9, 2020);
        hd.addPatient("Noah Miller", "Olivia Sanchez", 27, 2, 2019);
        hd.addPatient("Liam Davis", "Isabella Martinez", 3, 4, 2022);
        hd.addPatient("Ava Taylor", "Isabella Martinez", 15, 5, 2024);
        hd.addPatient("Mason Moore", "William Anderson", 7, 6, 2021);
        hd.addPatient("Charlotte Garcia", "Lucas Lewis", 30, 10, 2023);
        // Attempting to add a duplicate patient
        hd.addPatient("Noah Miller", "Olivia Sanchez", 27, 2, 2019);
        //hd.testTraversal();
        System.out.println(" ");

        // Displaying all patients
        hd.showAllPatients();

        System.out.println(" ");

        // Removing a patient from the hospital database
        hd.removePatient("Ava Taylor");
        System.out.println(" ");
        // Displaying all patients after removal
        hd.showAllPatients();

        System.out.println(" ");

        // Displaying detailed information of a specific patient
        hd.showPatientDetails("Michael Johnson");

        System.out.println(" ");

        // Adding medical staff members to patients' care teams
        hd.addMember("Mason Moore", "Daniel Roberts", "Nurse");
        hd.addMember("Mason Moore", "Victoria Stewart", "Radiologist");
        hd.addMember("Mason Moore", "Tyler Campbell", "Medical Assistant");
        hd.addMember("Mason Moore", "Hannah Martin", "Paramedic");
        hd.addMember("Michael Johnson", "Jack Allen", "Patient Care Technician");
        hd.addMember("Michael Johnson", "Oliver Nelson", "Anesthesiologist");
        hd.addMember("Michael Johnson", "Sophia Rivera", "Pathologist");
        hd.addMember("Michael Johnson", "Evan Hall", "Laboratory Technician");
        hd.addMember("Michael Johnson", "Megan Price", "Nurse");

        // Attempting to add a member to a non-existent patient
        hd.addMember("Ava Taylor", "Brianna Reed", "Dietitian"); // This should show an error

        hd.addMember("Charlotte Garcia", "Oliver Nelson", "Anesthesiologist");
        hd.addMember("Charlotte Garcia", "Trevor Jenkins", "Medical Equipment Technician");
        hd.addMember("Charlotte Garcia", "Justin Flores", "Speech-Language Pathologist");

        System.out.println(" ");

        // Displaying detailed information of specific patients
        hd.showPatientDetails("Mason Moore");
        System.out.println(" ");
        hd.showPatientDetails("Michael Johnson");

        System.out.println(" ");
        // Removing a medical staff member from a patient's care team
        hd.removeMember("Michael Johnson", "Evan Hall");
        System.out.println(" ");
        // Displaying detailed information of the patient after removal
        hd.showPatientDetails("Michael Johnson");

        System.out.println(" ");
        // Displaying patients under a specific doctor
        hd.showDoctorPatients("Olivia Sanchez");
        System.out.println(" ");
        hd.showDoctorPatients("Emma Thompson");

        System.out.println(" ");
        // Displaying patients for a specific visit year
        hd.showPatientsByYear(2022);

        System.exit(0);
    }
}
