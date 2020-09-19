package cn.xpbootcamp.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private int availableCapacity;
    private Map<Ticket, Bag> stores = new HashMap<>();



    public Locker(int initCapacity) {
        this.availableCapacity = initCapacity;

    }

    public Ticket save(Bag bag) {
        if(this.availableCapacity > 0){
            Ticket ticket = new Ticket();
            stores.put(ticket,bag);
            availableCapacity--;
            return ticket;
        }
        throw new LockerIsFullException();
    }

    public Bag pickupBy(Ticket ticket) {

        Bag bag =  stores.remove(ticket);

        if(bag == null){
            throw new InvalidTicketException();
        }

        return bag;
    }
}
