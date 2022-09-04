package ru.netology.domain;

public class AviaTicket implements Comparable<AviaTicket> {

    private int id;
    private int cost;
    private String departure;
    private String arrival;
    private int travelTime;


    public AviaTicket(int id, int cost, String departure, String arrival, int travelTime) {
        this.id = id;
        this.cost = cost;
        this.departure = departure;
        this.arrival = arrival;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    @Override
    public int compareTo(AviaTicket o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
