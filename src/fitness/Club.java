package fitness;


import java.time.LocalDateTime;

public class Club{

    Aboniment[] aboniments = new Aboniment[20];
    //String name;

    public void addAboniments(Aboniment... newAboniments) {
        for (int i = 0; i < aboniments.length; i++) {
            if (aboniments[i] == null) {
                for (int j = 0; j < newAboniments.length; j++) {

                    aboniments[i + j] = newAboniments[j];
                    //System.out.println(aboniments[i+j].people.toString());


                }
                break;
            }
        }
    }

    String[] types = {"Полный/Месячный", "Дневной", "Разовый"};

    public void visitClub (Visit visit){

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
                //visit.aboniment.n--;
            }
            else System.out.println("Разовый абонимент истек");
        }
    }


}
