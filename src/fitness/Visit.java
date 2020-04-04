package fitness;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Visit implements Zone{
    LocalDate visitDate;
    LocalTime visitTime;
    String zone;
    Aboniment aboniment;
    int nn;


    public Visit(LocalDate visitDate, LocalTime visitTime, String zone, Aboniment aboniment) {
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.zone = zone;
        this.aboniment = aboniment;
        this.nn = 0;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public LocalTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalTime visitTime) {
        this.visitTime = visitTime;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Aboniment getAboniment() {
        return aboniment;
    }

    public void setAboniment(Aboniment aboniment) {
        this.aboniment = aboniment;
    }

    public int getNn() {
        return nn;
    }

    public void setNn(int nn) {
        this.nn = nn;
    }

    void visitZone(Aboniment aboniment, Visit visit){

            if (zone.equalsIgnoreCase("бассейн")) swimmingPool(aboniment, visit);
            else if (zone.equalsIgnoreCase("групповые занятия")) group(aboniment, visit);
            else  if (zone.equalsIgnoreCase("тренажерный зал")) {

                LocalTime startGym = LocalTime.of(07, 59);
                LocalTime endGym = LocalTime.of(22, 01);
                if (visitTime.isAfter(startGym) && visitTime.isBefore(endGym)) gym(aboniment, visit);
                else System.out.println("Тренажерный зал закрыт");
            }


        //}
       // else System.out.println("Срок действия абонемента истек или не начал действовать");

    };
}
