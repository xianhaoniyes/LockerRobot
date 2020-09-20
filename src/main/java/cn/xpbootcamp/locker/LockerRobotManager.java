package cn.xpbootcamp.locker;

import java.util.List;

public class LockerRobotManager {

    private final List<Storeable> storeables;
    public LockerRobotManager(List<Storeable> list) {

        for(Storeable storeable: list){
            if (storeable instanceof Locker && ((Locker) storeable).getType()!=StoreType.SMALL)
                throw new IncorrectLockerTypeException();
        }
        this.storeables = list;

    }

    public Ticket save(Bag bag) {

        for (Storeable storeable:storeables ) {
            if(storeable.currentCapacity()>0)
                return  storeable.save(bag);
        }

        throw new LockerIsFullException();

    }

    public Bag pickupBy(Ticket ticket) {

        for(Storeable storeable:storeables){
            try {
                return  storeable.pickupBy(ticket);
            }
            catch (Exception ignored){
            }
        }

        throw new InvalidTicketException();

    }
}
