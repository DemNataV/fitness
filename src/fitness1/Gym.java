package fitness1;

import fitness1.Aboniment;
import fitness.Visit;

public class Gym {
    int count;

    void gym(Aboniment aboniment){
        System.out.println(aboniment.people.toString() + " посещает тренажерный зал ");
        //visit.nn++;
        aboniment.n--;
    };
}
