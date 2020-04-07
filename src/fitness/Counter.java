package fitness;

import java.time.LocalTime;

public class Counter {
    int gymCount;
    int groupCount;
    int sPCCount;

    public int getGymCount() {
        return gymCount;
    }

    public void setGymCount(int gymCount) {
        this.gymCount = gymCount;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        groupCount = groupCount;
    }

    public int getSPCCount() {
        return sPCCount;
    }

    public void setSPCCount(int SPCCount) {
        this.sPCCount = SPCCount;
    }

    void swimmingPool(Aboniment aboniment, Visit visit){
        if (aboniment.type.equalsIgnoreCase("Разовый") || aboniment.type.equalsIgnoreCase("Полный/Месячный")){

            LocalTime startSwimmingPool = LocalTime.of(07, 59);
            LocalTime endSwimmingPool = LocalTime.of(22, 01);
            if (visit.visitTime.isAfter(startSwimmingPool) && visit.visitTime.isBefore(endSwimmingPool)) {
                System.out.println(aboniment.people.toString() + " посещает бассейн ");
                visit.nn++;
                aboniment.n--;
                sPCCount++;
            }
            else {
                System.out.println("Бассейн закрыт");
            }
        }
        else {
            System.out.println(aboniment.people.toString() + " не имеет право посещаеть бассейн ");
        }
    };

    void group(Aboniment aboniment, Visit visit){

        LocalTime startGroup = LocalTime.of(07, 59);
        LocalTime endGroupD = LocalTime.of(22, 01);
        LocalTime endGroup = LocalTime.of(22, 01);

        if ((aboniment.type.equalsIgnoreCase("Дневной") && visit.visitTime.isAfter(startGroup) && visit.visitTime.isBefore(endGroupD))
                || (aboniment.type.equalsIgnoreCase("Полный/Месячный") && visit.visitTime.isAfter(startGroup) && visit.visitTime.isBefore(endGroup))){
            System.out.println(aboniment.people.toString() + " посещает групповые занятия ");
            visit.nn++;
            groupCount++;
        }
        else {
            System.out.println(aboniment.people.toString() + " не имеет право посещаеть групповые занятия по данному абонементу или в данное время");
        }
    };

    void gym(Aboniment aboniment, Visit visit){

        LocalTime startGym = LocalTime.of(07, 59);
        LocalTime endGymD = LocalTime.of(22, 01);
        LocalTime endGym = LocalTime.of(22, 01);

        if ((aboniment.type.equalsIgnoreCase("Дневной") && visit.visitTime.isAfter(startGym) && visit.visitTime.isBefore(endGymD))
                || ((aboniment.type.equalsIgnoreCase("Полный/Месячный") || aboniment.type.equalsIgnoreCase("Разовый"))
                && visit.visitTime.isAfter(startGym) && visit.visitTime.isBefore(endGym))) {


            System.out.println(aboniment.people.toString() + " посещает тренажерный зал ");
            visit.nn++;
            aboniment.n--;
            gymCount++;
        }
        else System.out.println("Тренажерный зал закрыт для посещений в это время для данного вида абонимента");
    };
}
