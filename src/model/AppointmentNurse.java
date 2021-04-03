package model;

import java.time.LocalDate;

public class AppointmentNurse implements ISchedulable {
  private int id;
  private Patient patient;
  private Nurse nurse;
  private LocalDate date;
  private String time;

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

  public Nurse getNurse() {
    return nurse;
  }

  public void setNurse(Nurse nurse) {
    this.nurse = nurse;
  }

  public LocalDate getDate() {
    return date;
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
  public void schedule(LocalDate date, String time) {

  }
}
