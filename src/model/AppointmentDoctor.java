package model;

import java.time.LocalDate;
import java.util.Date;

public class AppointmentDoctor implements ISchedulable {
  private int id;
  private Patient patient;
  private Doctor doctor;
  private LocalDate date;
  private String time;

  public AppointmentDoctor(Patient patient, Doctor doctor) {
    this.patient = patient;
    this.doctor = doctor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getTime() {
    return time + "hrs.";
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public void schedule(LocalDate date, String time) {
    this.date = date;
    this.time = time;
  }
}
