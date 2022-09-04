package ru.netology.manager;

import ru.netology.domain.AviaTicket;
import ru.netology.repository.AviaTicketsRepository;

import java.util.Arrays;

public class AviaTicketsManager {

    private AviaTicketsRepository repo;

    public AviaTicketsManager(AviaTicketsRepository repo) {
        this.repo = repo;
    }

    public void add(AviaTicket aviaTicket) {
        repo.add(aviaTicket);
    }

    public AviaTicket[] searchBy(String departure, String arrival) {
        AviaTicket[] result = new AviaTicket[0];
        for (AviaTicket aviaTicket : repo.findAll()) {
            if (aviaTicket.getDeparture().equalsIgnoreCase(departure) && aviaTicket.getArrival().equalsIgnoreCase(arrival)) {
               AviaTicket[] tmp = new AviaTicket[result.length + 1];
               System.arraycopy(result, 0, tmp,0, result.length);
               tmp[tmp.length - 1] = aviaTicket;
               result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
