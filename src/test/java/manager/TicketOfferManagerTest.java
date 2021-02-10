package manager;

import domain.TicketOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositiry.TicketOfferRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TicketOfferManagerTest {

    @InjectMocks
    private TicketOfferManager manager;

    @Mock
    private TicketOfferRepository repository;

    TicketOffer to1;
    TicketOffer to2;
    TicketOffer to3;
    TicketOffer Msk;
    TicketOffer Pnz;


    @BeforeEach
    private void setUp() {
        to1 = new TicketOffer(0, 100, "0", "1", 600);
        to2 = new TicketOffer(0, 300, "0", "1", 600);
        to3 = new TicketOffer(0, 200, "0", "1", 600);
        Msk = new TicketOffer(1, 500, "Msk", "Pnz", 800);
        Pnz = new TicketOffer(2, 600, "Pnz", "Msk", 800);
    }

    private TicketOffer[] getAllDumb() {
        return new TicketOffer[]{to1, to2, to3};
    }

    @Test
    void findAll() {
        TicketOffer[] returned = getAllDumb();
        doReturn(returned).when(repository).getAll();
        TicketOffer[] actual = manager.findAll("0", "1");
        assertArrayEquals(new TicketOffer[]{to1, to3, to2}, actual);
        verify(repository).getAll();
    }

    @Test
    void findNothing() {
        TicketOffer[] returned = getAllDumb();
        doReturn(returned).when(repository).getAll();
        TicketOffer[] actual = manager.findAll("1", "0");
        assertArrayEquals(new TicketOffer[]{}, actual);
        verify(repository).getAll();
    }
//    @Test
//    void filter() {
//        TicketOffer[] returned = getAllDumb();
//        doReturn(returned).when(repository).getAll();
//
//        assertArrayEquals(new TicketOffer[]{}, actual);
//        verify(repository).getAll();
//    }
}