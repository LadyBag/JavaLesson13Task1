package manager;

import domain.TicketOffer;
import repositiry.TicketOfferRepository;

import java.util.Arrays;

public class TicketOfferManager {
    private TicketOfferRepository repository = new TicketOfferRepository();

    public void add(TicketOffer TicketOffer) {
        repository.save(TicketOffer);
    }

    public TicketOffer[] findAll(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        TicketOffer[] TicketOffers = repository.getAll();
        for (TicketOffer item : TicketOffers) {
            if (matches(item, from, to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }

        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(TicketOffer ticketOffer, String from, String to) {
       return ticketOffer.getFrom().equalsIgnoreCase(from) && ticketOffer.getTo().equalsIgnoreCase(to);
    }

}


