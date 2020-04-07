package fitness;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //LocalDateTime startPeriod = LocalDateTime.of(2018, Month.JUNE, 10, 00, 00);
        //LocalDateTime endPeriod = LocalDateTime.of(2018, Month.OCTOBER, 20, 00, 00);

        String[] name = {"Анна", "Николай", "Петр", "Адольф", "Андрей", "Василиса", "Антон", "Анастасия", "Дарья"};
        String[] surname = {"Первая", "Третий", "Четвертый", "Пятая", "Шестой", "Седьмая", "Восьмой", "Девятая", "Десятая",
                "Одинадцатая", "Двенадцатый", "Тринадцатый", "Тринадцатый", "Пятнадцатая", "Шестнадцатый", "Семнадцатая", "Восемнадцатый"};

        /*People people1 = new People("Анна", "Первая");
        People people2 = new People("Николай", "Второй");
        People people3 = new People("Петр", "Третий");
        People people4 = new People("Адольф", "Четвертый");
        People people5 = new People("Марина", "Пятая");
        People people6 = new People("Андрей", "Шестой");
        People people7 = new People("Василиса", "Седьмая");
        People people8 = new People("Антон", "Восьмой");
        People people9 = new People("Анастасия", "Девятая");
        People people10 = new People("Дарья", "Десятая");

        People people11 = new People("Анна", "Одинадцатая");
        People people12 = new People("Николай", "Двенадцатый");
        People people13 = new People("Петр", "Тринадцатый");
        People people14 = new People("Адольф", "Четырнадцатый");
        People people15 = new People("Марина", "Пятнадцатая");
        People people16 = new People("Андрей", "Шестнадцатый");
        People people17 = new People("Василиса", "Семнадцатая");
        People people18 = new People("Антон", "Восемнадцатый");
        People people19 = new People("Анастасия", "Девятнадцатая");
        People people20 = new People("Дарья", "Двадцатая");

        People[] people = {people1, people2, people3, people4, people5,
                people6, people7, people8, people9, people10,
                people11, people12, people13, people14, people15,
                people16, people17, people18, people19, people20};*/

        People[] people = new People[100];
        for (int i = 0; i < people.length ; i++) {
            people[i] = new People(name[(int)(Math.random()*name.length)], surname[(int)(Math.random()*surname.length)]);
        }

        String[] types = {"Полный/Месячный", "Дневной", "Разовый"};
        String[] zones = {"тренажерный зал", "групповые занятия", "бассейн"};

        Aboniment[] aboniments = new Aboniment[people.length];



        for (int i = 0; i < people.length; i++) {
          aboniments[i] = new Aboniment(types[(int)(Math.random()*types.length)], people[i]);
          if (aboniments[i].type.equals(types[0])){
                LocalDate startAboniment = LocalDate.of(2019, (int)(Math.random()*12+1), (int)(Math.random()*27+1));
                aboniments[i].setStart(startAboniment);
                aboniments[i].setEnd(startAboniment.plusMonths(1));
                //n1++;
            }
            if (aboniments[i].type.equals(types[1])){
                LocalDate startAboniment = LocalDate.of(2019, (int)(Math.random()*12+1), (int)(Math.random()*27+1));
                aboniments[i].setStart(startAboniment);
                aboniments[i].setEnd(startAboniment.plusDays(1));
                //n2++;
            }

            System.out.println(aboniments[i].toString());
        }

        Club club = new Club();
        club.addAboniments(aboniments);


        Visit[][] visits = new Visit[365][(int) (Math.random() *50)];
        LocalDate visitDateVs = LocalDate.of(2019, 1, 1);
        LocalDate visitDate;
        for (int i = 0; i < visits.length; i++) {

            Counter counter = new Counter();

            counter.setGroupCount(0);
            counter.setGymCount(0);
            counter.setSPCCount(0);

            visitDate = visitDateVs.plusDays(i);
            for (int j = 0; j < visits[i].length; j++) {


                LocalTime visitTime = LocalTime.of((int) (Math.random() * 13), (int) (Math.random() * 60));
                visits[i][j] = new Visit(visitDate, visitTime, zones[(int) (Math.random() * zones.length)], club.aboniments[(int) (Math.random() * club.aboniments.length)]);

                club.visitClub(visits[i][j], counter);
            }

        }

        int[] nn1 = new  int[visits.length];
        int[] nn2 = new  int[visits.length];
        int[] nn3 = new  int[visits.length];

        for (int i = 0; i < visits.length ; i++) {
            for (int j = 0; j < visits[i].length; j++) {
                if (visits[i][j].nn > 0 && visits[i][j].zone.equals(zones[0])) nn1[i]++;
                else if (visits[i][j].nn > 0 && visits[i][j].zone.equals(zones[1])) nn2[i]++;
                else if (visits[i][j].nn > 0 && visits[i][j].zone.equals(zones[2])) nn3[i]++;
            }

        }

  /*      for (int i = 0; i < visits.length ; i++) {

            String[][] listGym = new String[visits.length][nn1[i]];
            String[][] listGr = new String[visits.length][nn2[i]];
            String[][] listSw = new String[visits.length][nn3[i]];
        }



        for (int i = 0; i < visits.length ; i++) {

            int n1 = 0;
            int n2 = 0;
            int n3 = 0;

            for (int j = 0; j < visits[i].length; j++) {
                if (visits[i][j].nn > 0 && visits[i][j].zone.equals(zones[0])) {
                    listGym[i][nn1[i]] = visits[i][j].aboniment.people.surname + " " + visits[i][j].aboniment.people.name;
                    n1++;
                } else if (visits[i][j].nn > 0 && visits[i][j].zone.equals(zones[1])) {
                    listGr[nn2] = visits[i][j].aboniment.people.surname + " " + visits[i][j].aboniment.people.name;
                    n2++;
                } else if (visits[i][j].nn > 0 && visits[i][j].zone.equals(zones[2])) {
                    listSw[nn3] = visits[i][j].aboniment.people.surname + " " + visits[i][j].aboniment.people.name;
                    n3++;
                }
            }

        }
        Arrays.sort(listGym);
        Arrays.sort(listSw);
        Arrays.sort(listGr);

        System.out.println("Посетители тренажерного зала: " + Arrays.toString(listGym));
        System.out.println("Посетители бассеина: " + Arrays.toString(listSw));
        System.out.println("Посетители групповых занятий: " + Arrays.toString(listGr));*/

    }
}
