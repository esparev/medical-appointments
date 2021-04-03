package model;

import java.time.LocalDate;
import java.util.Date;

public interface ISchedulable {

  void schedule(LocalDate date, String time);
}
