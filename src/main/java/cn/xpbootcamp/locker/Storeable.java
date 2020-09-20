package cn.xpbootcamp.locker;

public interface Storeable {

    Ticket save(Bag bag);

    Bag pickupBy(Ticket ticket);

    int currentCapacity();
}
