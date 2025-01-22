import java.util.List;
//--------------------------------------------------------
// Title: Hospital Database Class
// Author:Umutcan OKUMUŞ
// ID: 43057338238
// Section: 02
// Assignment: 3
// Description: This class represents a hospital database system. It allows adding,
//// removing, and managing patients and their associated medical staff (care team).
//// It also provides functionality to view and search patients based on specific criteria..
//--------------------------------------------------------
public class HospitalDatabase {
    private BST<Patient> patientTree; // Binary Search Tree to store patients sorted by visit year and name.

    //--------------------------------------------------------
    // Constructs a new HospitalDatabase object with an empty patient tree.
    // Precondition: None.
    // Postcondition: A HospitalDatabase object is created with an empty BST.
    //--------------------------------------------------------
    public HospitalDatabase() {
        patientTree = new BST<>();
    }

    //--------------------------------------------------------
    // Adds a new patient to the database.
    // Precondition: patientName and doctorName are valid Strings;
    // visitDay, visitMonth, visitYear are integers representing the visit date.
    // Postcondition: If the patient is not already in the tree, they are added.
    // Otherwise, an error message is printed.
    //--------------------------------------------------------
    public void addPatient(String patientName, String doctorName, int visitDay, int visitMonth, int visitYear) {
        String[] nameParts = patientName.split(" ");
        if (nameParts.length != 2) {
            System.out.println("ERROR: Invalid patient name format.");
            return;
        }
        Patient newPatient = new Patient(nameParts[0], nameParts[1], doctorName, visitDay, visitMonth, visitYear);
        if (patientTree.get(newPatient) != null) {
            System.out.println("ERROR: Patient " + patientName + " overwritten.");
        } else {
            System.out.println("INFO: Patient " + patientName + " has been added.");
            patientTree.put(newPatient);
        }
    }

    //--------------------------------------------------------
    // Removes a patient from the database.
    // Precondition: patientName is a valid String.
    // Postcondition: If the patient exists in the tree, they are removed.
    // Otherwise, an error message is printed.
    //--------------------------------------------------------
    public void removePatient(String patientName) {
        Patient remove = findPatientByName(patientName);
        if (remove != null) {
            patientTree.delete(remove);
            System.out.println("INFO: Patient " + patientName + " has been removed.");
        } else {
            System.out.println("ERROR: Patient " + patientName + " does not exist.");
        }
    }

    //--------------------------------------------------------
    // Adds a medical staff member to a patient's care team.
    // Precondition: patientName, memberName, and memberRole are valid Strings.
    // Postcondition: If the patient exists, the member is added to their care team.
    // Otherwise, an error message is printed.
    //--------------------------------------------------------
    public void addMember(String patientName, String memberName, String memberRole) {
        Patient patient = findPatientByName(patientName);
        if (patient != null) {
            String[] nameParts = memberName.split(" ");
            if (nameParts.length != 2) {
                System.out.println("ERROR: Invalid patient name format.");
                return;
            }
            Members newMember = new Members(nameParts[0], nameParts[1], memberRole);
            if (patient.getCareTeam().get(newMember) != null) {
                System.out.println("INFO: " + memberName + " already exists in the care team. Overwriting role.");
            } else {
                System.out.println("INFO: " + memberName + " added to patient " + patientName);
                patient.getCareTeam().put(newMember);
            }
        } else {
            System.out.println("ERROR: Patient " + patientName + " does not exist.");
        }
    }

    //--------------------------------------------------------
    // Removes a medical staff member from a patient's care team.
    // Precondition: patientName and memberName are valid Strings.
    // Postcondition: If the patient exists and the member is in their care team,
    // the member is removed. Otherwise, an error message is printed.
    //--------------------------------------------------------
    public void removeMember(String patientName, String memberName) {
        Patient patient = findPatientByName(patientName);
        if (patient != null) {
            Members removeMember = new Members(memberName.split(" ")[0], memberName.split(" ")[1], "");
            if (patient.getCareTeam().get(removeMember) != null) {
                patient.getCareTeam().delete(removeMember);
                System.out.println("INFO: " + memberName + " removed from patient " + patientName);
            } else {
                System.out.println("ERROR: " + memberName + " does not exist in the care team of " + patientName);
            }
        } else {
            System.out.println("ERROR: " + patientName + " does not exist.");
        }
    }

    //--------------------------------------------------------
    // Displays all patients in the database.
    // Precondition: None.
    // Postcondition: Prints the details of all patients in sorted order.
    //--------------------------------------------------------
    public void showAllPatients() {
        List<Patient> patients = patientTree.inOrderTraversal();
        if (patients.isEmpty()) {
            System.out.println("---none---");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    //--------------------------------------------------------
    // Displays the details of a specific patient.
    // Precondition: patientName is a valid String.
    // Postcondition: If the patient exists, their details are printed.
    // Otherwise, a message indicating no results is printed.
    //--------------------------------------------------------
    public void showPatientDetails(String patientName) {
        Patient patient = findPatientByName(patientName);
        if (patient != null) {
            System.out.println(patient.getName());
            System.out.println(patient.visitDay + "/" + patient.visitMonth + "/" + patient.visitYear);
            System.out.println(patient.getDoctorName());
            for (Object staff : patient.getCareTeam().inOrderTraversal()) {
                System.out.println(staff);
            }
        } else {
            System.out.println("--none---");
        }
    }

    //--------------------------------------------------------
    // Displays all patients associated with a specific doctor.
    // Precondition: doctorName is a valid String.
    // Postcondition: Prints all patients assigned to the doctor.
    //--------------------------------------------------------
    public void showDoctorPatients(String doctorName) {
        System.out.println(doctorName);
        int patientCount = 0;
        for (Patient patient : patientTree.inOrderTraversalDesc()) {
            if (doctorName.equals(patient.getDoctorName())) {
                System.out.println(patient.getName() + ", " + patient.visitDay + "/" + patient.visitDay + "/" + patient.visitYear);
                patientCount++;
            }
        }
        if (patientCount == 0) {
            System.out.println("---none---");
        }
    }

    //--------------------------------------------------------
    // Displays patients who visited in a specific year.
    // Precondition: year is a valid integer.
    // Postcondition: Prints all patients who visited in the given year.
    //--------------------------------------------------------
    public void showPatientsByYear(int year) {
        if (patientTree == null || patientTree.isEmpty()) {
            System.out.println(year);
            System.out.println("---none---");
            return;
        }

        System.out.println("Visit year: " + year);
        boolean found = false;

        for (Patient patient : patientTree.inOrderTraversalDesc()) {
            if (patient.visitYear == year) {
                System.out.println(patient.getName() + ", " + patient.visitDay + "/" + patient.visitMonth);
                found = true;
            }
        }

        if (!found) {
            System.out.println("---none---");
        }
    }

    //--------------------------------------------------------
    // Helper method to find a patient by name.
    // Precondition: patientName is a valid String.
    // Postcondition: Returns the patient object if found; otherwise, null.
    //--------------------------------------------------------
    private Patient findPatientByName(String patientName) {
        for (Patient patient : patientTree.inOrderTraversal()) {
            if (patient.getName().equals(patientName)) {
                return patient;
            }
        }
        return null;
    }

    //--------------------------------------------------------
    // Tests the in-order traversal of the patient tree.
    // Precondition: None.
    // Postcondition: Prints all patients in sorted order or indicates if the tree is empty.
    //--------------------------------------------------------
   /* public void testTraversal() {
        if (patientTree.isEmpty()) {
            System.out.println("--none---");
            return;
        }

        System.out.println("Testing in-order traversal:");
        for (Patient patient : patientTree.inOrderTraversal()) {
            System.out.println(patient.getName() + ", " + patient.visitDay + "/" + patient.visitMonth + "/" + patient.visitYear);
        }
    } */
}


