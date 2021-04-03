package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

  public static final String [] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
  public static Doctor doctorLogged;
  public static Patient patientLogged;

  public static void showMenu() {
    System.out.println("\nWelcome to Appointments");
    System.out.println("=======================");
    System.out.println("Select the desired option");

    int response = 0;
    do {
      System.out.println("1. Doctor");
      System.out.println("2. Patient");
      System.out.println("0. Exit");

      System.out.print("-> ");
      Scanner sc = new Scanner(System.in);
      response = sc.nextInt();

      switch(response) {
        case 1:
          System.out.println("\nDoctor");
          response = 0;
          authUser(1);
          break;
        case 2:
          System.out.println("\nPatient");
          response = 0;
          authUser(2);
          break;
        case 0:
          response = 0;
          break;
        default:
          break;
      }
    } while(response != 0);
  }

  private static void authUser(int userType) {
    //userType = 1 Doctor
    //userType = 2 Patient

    ArrayList<Doctor> doctors = new ArrayList<>();
    doctors.add(new Doctor("Sebastian", "sebastian.rulli@doctor.com"));
    doctors.add(new Doctor("Lois", "lois.lane@doctor.com"));
    doctors.add(new Doctor("John", "john.connor@doctor.com"));
    doctors.add(new Doctor("Stephen", "strange@doctor.com"));
    doctors.add(new Doctor("Mr. Doctor", "mr@doctor.com"));

    ArrayList<Patient> patients = new ArrayList<>();
    patients.add(new Patient("Carlos", "patient@email.com"));
    patients.add(new Patient("Hendrix", "later@future.com"));
    patients.add(new Patient("Bobby", "bobbyboy@records.com"));
    patients.add(new Patient("Rakim", "fasteststone@rocky.com"));
    patients.add(new Patient("Esparev", "esparev@hotmail.com"));

    boolean emailCorrect = false;
    do {
      System.out.print("Insert your email [example@mail.com] \n-> ");
      Scanner sc = new Scanner(System.in);
      String email = sc.nextLine();

      if(userType == 1) {
        for(Doctor doc : doctors) {
          if(doc.getEmail().equals(email)) {
            emailCorrect = true;
            doctorLogged = doc;
            UIDoctorMenu.showDoctorMenu();
          }
          else {
            emailCorrect = false;
          }
        }
        if(!emailCorrect) {
          System.out.println("Email not found\n");
        }
      }
      if(userType == 2) {
        for(Patient pat : patients) {
          if(pat.getEmail().equals(email)) {
            emailCorrect = true;
            patientLogged = pat;
            UIPatientMenu.showPatientMenu();
          }
          else {
            emailCorrect = false;
          }
        }
        if(!emailCorrect) {
          System.out.println("Email not found\n");
        }
      }
    } while(!emailCorrect);

  }

  public static  void showPatientMenu() {
    int response = 0;
    do {
      System.out.println("\n\n");
      System.out.println("model.Patient");
      System.out.println("1. Book an appointment");
      System.out.println("2. My appointments");
      System.out.println("0. Return");

      Scanner sc = new Scanner(System.in);
      response = sc.nextInt();

      switch (response) {
        case 1:
          System.out.println("::Book an appointment");
          for (int i = 1; i < 4; i++) {
            System.out.println(i + ". " + MONTHS[i - 1]);
          }
          break;
        case 2:
          System.out.println("::My appointments");
          break;
        case 0:
          showMenu();
          break;
      }
    }while (response != 0);
  }

}
