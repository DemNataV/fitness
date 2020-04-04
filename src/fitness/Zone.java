package fitness;

public interface Zone {
    default void swimmingPool(Aboniment aboniment, Visit visit){
        if (aboniment.type.equalsIgnoreCase("Разовый") || aboniment.type.equalsIgnoreCase("Полный/Месячный")){
            System.out.println(aboniment.people.toString() + " посещает бассейн ");
            visit.nn++;
        }
        else {
            System.out.println(aboniment.people.toString() + " не имеет право посещаеть бассейн ");
        }
    };

    default void group(Aboniment aboniment, Visit visit){
        if (aboniment.type.equalsIgnoreCase("Дневной") || aboniment.type.equalsIgnoreCase("Полный/Месячный")){
            System.out.println(aboniment.people.toString() + " посещает групповые занятия ");
            visit.nn++;
        }
        else {
            System.out.println(aboniment.people.toString() + " не имеет право посещаеть групповые занятия ");
        }
    };

    default void gym(Aboniment aboniment, Visit visit){
            System.out.println(aboniment.people.toString() + " посещает тренажерный зал ");
        visit.nn++;
    };
}
