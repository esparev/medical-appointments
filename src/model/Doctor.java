package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
//  static int id = 0; // Autoincrement
  private String specialty;
  private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

  public Doctor(String name, String email) {
    super(name, email);
  }

  // Behaviors

  public void addAvailableAppointment(String date, String time) {
    availableAppointments.add(new AvailableAppointment(date, time));
  }

  public ArrayList<AvailableAppointment> getAvailableAppointments() {
    return availableAppointments;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  @Override
  public String toString() {
    return super.toString() + "\nSpecialty: " + specialty + "\nAvailable : " + availableAppointments.toString();
  }

  @Override
  public void showDataUser() {
    System.out.println("Employee of the Hospital: Red Cross");
    System.out.println("Department: Cancerology");
  }

  public static class AvailableAppointment {
    private int id_availableAppointment;
    private LocalDate date;
    private String time;
    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

//    public AvailableAppointment(String date, String time) {
//      try {
//        this.date = format.parse(date);
//      } catch (ParseException e) {
//        e.printStackTrace();
//      }
//      this.time = time;
//    }
    public AvailableAppointment(String date, String time) {
      this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
      this.time = time;
    }

    public int getId_availableAppointment() {
      return id_availableAppointment;
    }

    public void setId_availableAppointment(int id_availableAppointment) {
      this.id_availableAppointment = id_availableAppointment;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDate(String DATE) {
        return format.format(date);
    }

    public void setDate(LocalDate date) {
      this.date = date;
    }

    public String getTime() {
      return time;
    }

    public void setTime(String time) {
      this.time = time;
    }

    @Override
    public String toString() {
      return "Available Appointments \nDate: " + date + "\nTime: " + time;
    }
  }

}
