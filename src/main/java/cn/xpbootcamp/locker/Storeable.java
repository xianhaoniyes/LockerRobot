package cn.xpbootcamp.locker;

public interface Storeable {

    public  Ticket save(Bag bag);

    public Bag pickupBy(Ticket ticket);

    public int currentCapacity();
}
