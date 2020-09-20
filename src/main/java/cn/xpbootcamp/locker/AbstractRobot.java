package cn.xpbootcamp.locker;

import java.util.List;

public abstract class  AbstractRobot implements Storeable {

    private final List<Locker> lockers;
    private final StoreType storeType;

    public AbstractRobot(List<Locker> list, StoreType storeType) {

        this.storeType = storeType;

        for (Locker locker:list) {
            if (locker.getType()!= this.storeType)
                throw new IncorrectLockerType();
        }
        this.lockers = list;
    }

    public abstract Ticket save(Bag bag);

    public Bag pickupBy(Ticket ticket) {

        if(ticket.getType()!=this.storeType)
            throw new TicketTypeNotMatchException();
        for(Locker locker:lockers){
            try {
                return  locker.pickupBy(ticket);
            }
            catch (Exception ignored){
            }
        }
        throw new InvalidTicketException();
    }

    public List<Locker> getLockers() {
        return lockers;
    }
}
