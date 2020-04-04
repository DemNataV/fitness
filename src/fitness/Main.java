package fitness;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //LocalDateTime startPeriod = LocalDateTime.of(2018, Month.JUNE, 10, 00, 00);
        //LocalDateTime endPeriod = LocalDateTime.of(2018, Month.OCTOBER, 20, 00, 00);

        People people1 = new People("Анна", "Первая");
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
                people16, people17, people18, people19, people20};
        String[] types = {"Полный/Месячный", "Дневной", "Разовый"};
        String[] zones = {"тренажерный зал", "групповые занятия", "бассейн"};

        Aboniment[] aboniments = new Aboniment[20];



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

       /* String[][] listSw = new String[club.aboniments.length-n2][2];
        String[][] listGroup = new String[n1+n2][2];
        String[][] listGym = new String[club.aboniments.length][2];

        for (int i = 0; i < club.aboniments.length ; i++) {
            if (club.aboniments[i].equals(types[0])){


            }

        }*/

        Visit[] visits = new Visit[300];
        for (int i = 0; i < visits.length; i++) {
            LocalDate visitDate = LocalDate.of(2019, (int) (Math.random() * 12 + 1), (int) (Math.random() * 27 + 1));
            LocalTime visitTime = LocalTime.of((int) (Math.random() * 13), (int) (Math.random() * 60));
            visits[i] = new Visit(visitDate, visitTime, zones[(int) (Math.random() * zones.length)], club.aboniments[(int) (Math.random() * club.aboniments.length)]);

            club.visitClub(visits[i]);

        }

        int nn1 = 0;
        int nn2 = 0;
        int nn3 = 0;

        for (int i = 0; i < visits.length ; i++) {
            if(visits[i].nn > 0 && visits[i].zone.equals(zones[0])) nn1++;
            else if(visits[i].nn > 0 && visits[i].zone.equals(zones[1])) nn2++;
            else if(visits[i].nn > 0 && visits[i].zone.equals(zones[2])) nn3++;

        }

        String[] listGym = new String[nn1];
        String[] listGr = new String[nn2];
        String[] listSw = new String[nn3];

        nn1 = 0;
        nn2 = 0;
        nn3 = 0;

        for (int i = 0; i < visits.length ; i++) {
            if(visits[i].nn > 0 && visits[i].zone.equals(zones[0])) {
                listGym[nn1] = visits[i].aboniment.people.surname + " " + visits[i].aboniment.people.name;
                nn1++;
            }
            else if(visits[i].nn > 0 && visits[i].zone.equals(zones[1])) {
                listGr[nn2] = visits[i].aboniment.people.surname + " " + visits[i].aboniment.people.name;
                nn2++;
            }
            else if(visits[i].nn > 0 && visits[i].zone.equals(zones[2])) {
                listSw[nn3] = visits[i].aboniment.people.surname + " " + visits[i].aboniment.people.name;
                nn3++;
            }

        }
        Arrays.sort(listGym);
        Arrays.sort(listSw);
        Arrays.sort(listGr);

        System.out.println("Посетители тренажерного зала: " + Arrays.toString(listGym));
        System.out.println("Посетители бассеина: " + Arrays.toString(listSw));
        System.out.println("Посетители групповых занятий: " + Arrays.toString(listGr));

    }
}
