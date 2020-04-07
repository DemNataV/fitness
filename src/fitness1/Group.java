package fitness1;

import fitness1.Aboniment;
import fitness.Visit;

public class Group {
    int count;

    void group(Aboniment aboniment){
        if (aboniment.type.equalsIgnoreCase("Дневной") || aboniment.type.equalsIgnoreCase("Полный/Месячный")){
            System.out.println(aboniment.people.toString() + " посещает групповые занятия ");
            //visit.nn++;
        }
        else {
            System.out.println(aboniment.people.toString() + " не имеет право посещаеть групповые занятия ");
        }
    };
}
