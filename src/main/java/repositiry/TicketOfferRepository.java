package repositiry;

import domain.TicketOffer;

public class TicketOfferRepository {
    private TicketOffer[] items = new TicketOffer[0];

    public void save(TicketOffer item) {
        int length = items.length + 1;
        TicketOffer[] newTicketOffers = new TicketOffer[length];
        for (int i = 0; i < items.length; i++) {
            newTicketOffers[i] = items[i];
        }
        newTicketOffers[items.length] = item;
        this.items = newTicketOffers;
    }

    public TicketOffer[] getAll() {
        return items;
    }

    private TicketOffer findById(int id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id)
                return items[i];
        }

        return null;
    }



}
