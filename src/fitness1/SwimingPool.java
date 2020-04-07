package fitness1;

import fitness1.Aboniment;


public class SwimingPool {
    int count;

    public void swimmingPool(Aboniment aboniment){
        if (aboniment.type.equalsIgnoreCase("Разовый") || aboniment.type.equalsIgnoreCase("Полный/Месячный")){
            System.out.println(aboniment.people.toString() + " посещает бассейн ");
            //visit.nn++;
            aboniment.n--;
        }
        else {
            System.out.println(aboniment.people.toString() + " не имеет право посещаеть бассейн ");
        }
    };
}
