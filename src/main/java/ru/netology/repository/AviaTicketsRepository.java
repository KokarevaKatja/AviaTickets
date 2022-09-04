package ru.netology.repository;

import ru.netology.domain.AviaTicket;

public class AviaTicketsRepository {

    private AviaTicket[] aviaTickets = new AviaTicket[0];

    public void add(AviaTicket aviaTicket) {
        int length = aviaTickets.length + 1;
        AviaTicket[] tmp = new AviaTicket[length];
        System.arraycopy(aviaTickets, 0, tmp, 0, aviaTickets.length);
        tmp[tmp.length - 1] = aviaTicket;
        aviaTickets = tmp;
    }

    public AviaTicket[] removeById(int id) {
            if (findById(id) == null) {
                throw new NotFoundException(
                        "Element with id: " + id + " not found"
                );
            }
        int length = aviaTickets.length - 1;
        AviaTicket[] tmp = new AviaTicket[length];
        int copyToIndex = 0;
        for (AviaTicket aviaTicket : aviaTickets) {
            if (aviaTicket.getId() != id) {
                tmp[copyToIndex] = aviaTicket;
                copyToIndex++;
            }
        }
        aviaTickets = tmp;
        return aviaTickets;
    }

    public AviaTicket[] findAll() {
        return aviaTickets;
    }

    public AviaTicket[] getAviaTickets() {
        return aviaTickets;
    }

    public AviaTicket findById(int id) {
        for(AviaTicket aviaTicket : aviaTickets) {
            if (aviaTicket.getId() == id) {
                return aviaTicket;
            }
        }
        return null;
    }
}
