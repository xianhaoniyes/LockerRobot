package cn.xpbootcamp.locker;

public class Locker {

    private int availableCapacity;

    public Locker(int initCapacity) {
        this.availableCapacity = initCapacity;

    }

    public Ticket save(Bag bag) {
        if(this.availableCapacity > 0){
            availableCapacity--;
            return new Ticket();
        }
        throw new LockerIsFullException();
    }
}
