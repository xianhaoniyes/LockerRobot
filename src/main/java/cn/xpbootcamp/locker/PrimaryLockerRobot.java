package cn.xpbootcamp.locker;

import java.util.List;

public class PrimaryLockerRobot {

    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> list) {
        for (Locker locker:list) {
            if (locker.getType()!=StoreType.MEDIUM)
                throw new IncorrectLockerType();
        }
        this.lockers = list;
    }

    public Ticket save(Bag bag) {
        for (Locker locker: lockers) {
            if (locker.currentCapacity() > 0){
                return locker.save(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
