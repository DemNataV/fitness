package fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Club{

    Aboniment[] aboniments = new Aboniment[20];
    //String name;

    public void addAboniments(Aboniment... newAboniments) {
        for (int i = 0; i < aboniments.length; i++) {
            if (aboniments[i] == null) {
                for (int j = 0; j < newAboniments.length; j++) {

                    aboniments[i + j] = newAboniments[j];
                    System.out.println(aboniments[i+j].people.toString());


                }
                break;
            }
        }
    }

    String[] types = {"Полный/Месячный", "Дневной", "Разовый"};

    public void visitClub (Visit visit){
        //LocalDate visitDate = LocalDate.of(2019, (int) (Math.random() * 12 + 1), (int) (Math.random() * 27 + 1));
        //LocalTime visitTime = LocalTime.of((int) (Math.random() * 13), (int) (Math.random() * 60));
        //visit = new Visit(visitDate, visitTime, zones[(int) (Math.random() * zones.length)], aboniments[(int) (Math.random() * aboniments.length)]);

        LocalDateTime visitDateTime = LocalDateTime.of(visit.visitDate, visit.visitTime);
        System.out.println(visit.aboniment.toString() + " хочет пройти в " + visit.zone + " " + visit.visitDate + " в " + visit.visitTime);

        if (visit.aboniment.type.equalsIgnoreCase(types[0]) || visit.aboniment.type.equalsIgnoreCase(types[1])) {

            if (visit.visitDate.isAfter(visit.aboniment.start) && visit.visitDate.isBefore(visit.aboniment.end)) {
                visit.visitZone(visit.aboniment, visit);
            } else {
                System.out.println("Срок действия абонемента истек или не начал действовать");
            }
        } else if (visit.aboniment.type.equalsIgnoreCase(types[2])) {
            if (visit.aboniment.n > 0) {
                visit.visitZone(visit.aboniment, visit);
                visit.aboniment.n--;
            }
            else System.out.println("Разовый абонимент истек");
        }
    }


}
