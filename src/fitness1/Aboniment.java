package fitness1;


import fitness.People;

import java.time.LocalDate;

public class Aboniment {
    public String type; // = {"Разовый", "Дневной", "Полный/Месячный"};
    LocalDate start;
    LocalDate end;
    People people;
    int n;

    public Aboniment(String type, People people) {
        this.type = type;
        this.people = people;
        this.n = 1;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Aboniment{" +
                "type='" + type + '\'' +
                ", start=" + start +
                ", end=" + end +
                people.toString() +
                '}';
    }
}
