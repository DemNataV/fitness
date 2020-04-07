package fitness;


import java.time.LocalDate;
import java.time.LocalTime;


public class Visit{
    LocalDate visitDate;
    LocalTime visitTime;

    LocalTime leaveTime;
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

    public LocalTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    void visitZone(Aboniment aboniment, Visit visit, Counter counter){

            if (zone.equalsIgnoreCase("бассейн") && counter.sPCCount < 21) counter.swimmingPool(aboniment, visit);
            else if (zone.equalsIgnoreCase("групповые занятия") && counter.groupCount < 21) counter.group(aboniment, visit);
            else  if (zone.equalsIgnoreCase("тренажерный зал") && counter.gymCount < 21) counter.gym(aboniment, visit);
            else System.out.println("Лимит по количеству людей данной зоны исчерпан");

    };
}
