package ui;

import model.Doctor;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
  static Scanner sc = new Scanner(System.in);

  public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

  public static void showDoctorMenu() {
    int response = 0;
    do {
      System.out.println("\n\n");
      System.out.println("::::: Doctor :::::");
      System.out.println("Welcome " + UIMenu.doctorLogged.getName());
      System.out.println("1. Add Available Appointments");
      System.out.println("2. My Scheduled Appointments");
      System.out.println("0. Logout");

      System.out.print("-> ");
      response = sc.nextInt();

      switch(response) {
        case 1:
          showAddAvailableApointmentsMenu();
          break;
        case 2:
          System.out.println(UIMenu.doctorLogged.getAvailableAppointments());
          break;
        case 0:
          System.out.println("Goodbye " + UIMenu.doctorLogged.getName());
          UIMenu.showMenu();
          break;
      }
    } while (response != 0);
  }

  private static void showAddAvailableApointmentsMenu() {
    int response = 0;
    do {
      System.out.println("\nAdd Available Appointments ");

      for(int i = 0; i < 12; i++) {
        System.out.println((i + 1) + ". " + UIMenu.MONTHS[i]);
      }
      System.out.println("0. Return");

      System.out.print("\nSelect a Month \n-> ");
      response = sc.nextInt();

      if (response > 0 && response < 13) {
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        int monthSelected = response;

        System.out.print("\nInsert the date available [dd/mm/yyyy] \n-> ");
        String date = sc.next();

        LocalDate localDate = LocalDate.now();
        int localYear = (int)localDate.getYear();
        int userInputYear = Integer.parseInt(date.substring(6));

        if(localYear > userInputYear) {
          System.out.println("Error, choose from the year " + String.valueOf(localDate.getYear()));
          date = "Invalid";
        }

        if(!date.equals("Invalid")) {
          for (int i = 1; i < 13; i++) {
            if (i == monthSelected && monthSelected < 10) {
              if (!date.contains("/0".concat(String.valueOf(i)).concat("/"))) {
                System.out.println("Error, invalid month");
                date = "Invalid";
                break;
              }
            }
            if (i == monthSelected && monthSelected > 10 && monthSelected < 13) {
              if (!date.contains("/".concat(String.valueOf(i)).concat("/"))) {
                System.out.println("Error, invalid month");
                date = "Invalid";
                break;
              }
            }
          }
        }

        System.out.print("\nYour date is: " + date + "\n");
        if(!date.equals("Invalid")) {
          System.out.println("1. Correct");
        }
        System.out.println("2. Change Date");
        System.out.println("0. Return");

        System.out.print("-> ");
        int responseDate = sc.nextInt();

        if(responseDate == 2 || responseDate == 0) continue;

        int responseTime = 0;
        String time = "";
        do {
          System.out.print("\nInsert the time available for date: " + date + " [24:00] \n-> ");
          time = sc.next();

          System.out.println("\nYour time is: " + time);
          System.out.println("1. Correct");
          System.out.println("2. Change Time");
          System.out.println("0. Return");

          System.out.print("-> ");
          responseTime = sc.nextInt();

        } while(responseTime == 2);
        UIMenu.doctorLogged.addAvailableAppointment(date, time);
        checkDoctorAvailableAppointments(UIMenu.doctorLogged);
      }
      else if(response == 0) {
        showDoctorMenu();
      }
    } while(response != 0);
  }

  private static void checkDoctorAvailableAppointments(Doctor doctor) {
    if(doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor))
      doctorsAvailableAppointments.add(doctor);
  }
}
