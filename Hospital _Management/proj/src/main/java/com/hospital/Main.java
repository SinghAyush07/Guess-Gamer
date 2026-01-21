package com.hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
       
            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    scheduleAppointment(scanner);
                    break;
                case 4: 
                    viewPatients();
                    break;
                case 5: 
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 0: 
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while(choice != 0);
        
        scanner.close();
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: "); 
        String name = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Patient patient = new Patient(name, gender, age);
        patients.add(patient);
        System.out.println("Patient Added Successfully!");
    }

    private static void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: "); 
        String name = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Doctor doctor = new Doctor(name, gender, age);
        doctors.add(doctor);
        System.out.println("Doctor Added Successfully!");
    }

    private static void scheduleAppointment(Scanner scanner) {
        if (patients.isEmpty()) {
            System.out.println("No patients available. Please add a patient first.");
            return;
        }
        if (doctors.isEmpty()) {
            System.out.println("No doctors available. Please add a doctor first.");
            return;
        }

        System.out.println("\n--- Available Patients ---");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).toString());
        }
        System.out.print("Select Patient (enter number): ");
        int patientIndex = scanner.nextInt() - 1;

        System.out.println("\n--- Available Doctors ---");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).toString());
        }
        System.out.print("Select Doctor (enter number): ");
        int doctorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Appointment Date (e.g., 2026-01-25): ");
        String date = scanner.nextLine();

        if (patientIndex >= 0 && patientIndex < patients.size() && 
            doctorIndex >= 0 && doctorIndex < doctors.size()) {
            Appointment appointment = new Appointment(
                patients.get(patientIndex), 
                doctors.get(doctorIndex), 
                date
            );
            appointments.add(appointment);
            System.out.println("Appointment Scheduled Successfully!");
        } else {
            System.out.println("Invalid selection. Appointment not scheduled.");
        }
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("\n=== List of Patients ===");
        for (Patient patient : patients) {
            System.out.println(patient.toString());
            System.out.println("---");
        }
    }

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
            return;
        }
        System.out.println("\n=== List of Doctors ===");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
            System.out.println("---");
        }
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        System.out.println("\n=== List of Appointments ===");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.toString());
            System.out.println("---");
        }
    }
}