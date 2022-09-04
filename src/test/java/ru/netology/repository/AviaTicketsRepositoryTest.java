package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AviaTicket;

import java.util.Arrays;

public class AviaTicketsRepositoryTest {

    AviaTicketsRepository repo = new AviaTicketsRepository();

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

    @BeforeEach
    public void setup() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
    }

    @Test
    public void shouldAddSixth() {
        repo.add(ticket6);

        AviaTicket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        AviaTicket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllFive() {
        AviaTicket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        AviaTicket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveOne() {
        repo.removeById(ticket2.getId());

        AviaTicket[] expected = {ticket1, ticket3, ticket4, ticket5};
        AviaTicket[] actual = repo.getAviaTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repo.removeById(ticket1.getId());
        repo.removeById(ticket2.getId());
        repo.removeById(ticket3.getId());
        repo.removeById(ticket4.getId());
        repo.removeById(ticket5.getId());

        AviaTicket[] expected = {};
        AviaTicket[] actual = repo.getAviaTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotExistingId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(58);
        });
    }

    @Test
    public void shouldSortByPrice() {

        AviaTicket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(expected);
        AviaTicket[] actual = {ticket1, ticket2, ticket4, ticket3, ticket5};
        Arrays.sort(expected);

        Assertions.assertArrayEquals(expected, actual);

    }
}
