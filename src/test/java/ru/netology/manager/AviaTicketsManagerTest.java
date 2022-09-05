package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AviaTicket;
import ru.netology.repository.AviaTicketsRepository;

public class AviaTicketsManagerTest {

    AviaTicketsRepository repo = new AviaTicketsRepository();
    AviaTicketsManager manager = new AviaTicketsManager(repo);
    private String LED = "Пулково";
    private String SVO = "Шереметьево";
    private String BUD = "Ферихедь";
    private String TXL = "Тегель";
    private String MAD = "Барахас";
    private String LHR = "Хитроу";


    AviaTicket ticket1 = new AviaTicket(154, 4355, SVO, LED, 1);
    AviaTicket ticket2 = new AviaTicket(36, 7745, LED, TXL, 2);
    AviaTicket ticket3 = new AviaTicket(787, 12467, TXL, SVO, 10);
    AviaTicket ticket4 = new AviaTicket(12, 9877, BUD, MAD, 3);
    AviaTicket ticket5 = new AviaTicket(333, 34333, MAD, LHR, 4);
    AviaTicket ticket6 = new AviaTicket(925, 21999, LHR, BUD, 7);
    AviaTicket ticket7 = new AviaTicket(467, 6678, SVO, LED, 1);
    AviaTicket ticket8 = new AviaTicket(34, 9067, SVO, LED, 1);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldFindOneTicket() {
        AviaTicket[] expected = {ticket6};
        AviaTicket[] actual = manager.searchBy(LHR, BUD);

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByWrongDeparture() {
        AviaTicket[] expected = manager.searchBy("", "MAD");
        AviaTicket[] actual = new AviaTicket[] {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWrongArrival() {
        AviaTicket[] expected = manager.searchBy("TXL", "");
        AviaTicket[] actual = new AviaTicket[] {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWrongDepartureAndArrival() {
        AviaTicket[] expected = manager.searchBy("", "");
        AviaTicket[] actual = new AviaTicket[] {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTickets() {
        manager.add(ticket7);
        manager.add(ticket8);

        AviaTicket[] expected = {ticket1, ticket7, ticket8};
        AviaTicket[] actual = manager.searchBy(SVO, LED);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindNoneTickets() {
        AviaTicket[] expected = {};
        AviaTicket[] actual = manager.searchBy(MAD, SVO);

        Assertions.assertArrayEquals(expected, actual);
    }
}
