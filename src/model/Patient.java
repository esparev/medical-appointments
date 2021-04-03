package model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Patient extends User {
  private String birthday;
  private double weight;
  private double height;
  private String blood;

  private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
  private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

  public Patient(String name, String email) {
    super(name, email);
  }

  public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
    return appointmentDoctors;
  }

  public void addAppointmentDoctors(Doctor doctor, LocalDate date, String time) {
    AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
    appointmentDoctor.schedule(date, time);
    appointmentDoctors.add(appointmentDoctor);
  }

  public ArrayList<AppointmentNurse> getAppointmentNurses() {
    return appointmentNurses;
  }

  public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
    this.appointmentNurses = appointmentNurses;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getWeight() {
    return weight + " Kg.";
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getHeight() {
    return height + " Mts.";
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public String getBlood() {
    return blood;
  }

  public void setBlood(String blood) {
    this.blood = blood;
  }

  @Override
  public String toString() {
    return super.toString() + "\nAge: " + birthday + "\nWeight: " + getWeight() + "\nHeight: " + getHeight() + "\nBlood Type: " + blood;
  }

  @Override
  public void showDataUser() {
    System.out.println("Patient");
    System.out.println("Complete history since the day of birth");
  }
}
