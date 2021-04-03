package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
  static Scanner sc = new Scanner(System.in);
  public static void showPatientMenu() {
    int response = 0;
    do {
      System.out.println("\n\n");
      System.out.println("::::: Patient :::::");
      System.out.println("Welcome " + UIMenu.patientLogged.getName());
      System.out.println("1. Book an Appointment");
      System.out.println("2. My Appointments");
      System.out.println("0. Logout");

      System.out.print("-> ");
      response = sc.nextInt();

      switch (response) {
        case 1:
          showBookAppointmentMenu();
          break;
        case 2:
          showPatientMyAppointments();
          break;
        case 0:
          System.out.println("Goodbye " + UIMenu.patientLogged.getName());
          UIMenu.showMenu();
          break;
      }

    } while (response != 0);
  }

  private static void showBookAppointmentMenu() {
    int response = 0;
    do {
      System.out.println("Book an Appointment");

      Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
      int k = 0;
      for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
        ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
        Map<Integer, Doctor> doctorAppointment = new TreeMap<>();

        for (int j = 0; j < availableAppointments.size(); j++) {
          k++;
          System.out.println(k + ". " + availableAppointments.get(j).getDate());
          doctorAppointment.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));

          doctors.put(Integer.valueOf(k), doctorAppointment);
        }

        System.out.print("\nSelect date \n-> ");
        int responseDateSelected = sc.nextInt();

        Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
        Integer indexDate = 0;
        Doctor doctorSelected = new Doctor("", "");

        for(Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
          indexDate = doc.getKey();
          doctorSelected = doc.getValue();
        }
        System.out.println(doctorSelected.getName() +
                ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());

        System.out.println("Confirm your appointment \n");
        System.out.println("1. Yes");
        System.out.println("2. Change Date");
        System.out.println("0. Return");

        System.out.print("-> ");
        response = sc.nextInt();

        if (response == 1) {
          UIMenu.patientLogged.addAppointmentDoctors(
                  doctorSelected,
                  doctorSelected.getAvailableAppointments().get(indexDate).getDate(),
                  doctorSelected.getAvailableAppointments().get(indexDate).getTime());

          showPatientMenu();
        }
      }
    } while (response != 0);
  }

  private static void showPatientMyAppointments(){
    int response = 0;
    do {
      System.out.println("\nMy Appointments");
      if(UIMenu.patientLogged.getAppointmentDoctors().size() == 0) {
        System.out.println("You don't have an appointment");
        break;
      }
      for(int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
        System.out.println((i + 1) + ". Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                "\nTime : " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
      }
      System.out.println("0. Return");
    } while(response != 0);
  }
}
