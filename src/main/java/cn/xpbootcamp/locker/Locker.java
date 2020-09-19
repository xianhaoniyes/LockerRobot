package cn.xpbootcamp.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private int availableCapacity;
    private StoreType type;
    private Map<Ticket, Bag> stores = new HashMap<>();

    public Locker(int initCapacity, StoreType type) {
        this.availableCapacity = initCapacity;
        this.type = type;

    }

    public Ticket save(Bag bag) {
        if(this.availableCapacity > 0){
            Ticket ticket = new Ticket(this.type);
            stores.put(ticket,bag);
            availableCapacity--;
            return ticket;
        }
        throw new LockerIsFullException();
    }

    public Bag pickupBy(Ticket ticket) {

        if(this.type!=ticket.getType())
            throw new TypeNotMatchException();

        Bag bag =  stores.remove(ticket);

        if(bag == null){
            throw new InvalidTicketException();
        }

        return bag;
    }

    public StoreType getType(){
        return this.type;
    }
}
