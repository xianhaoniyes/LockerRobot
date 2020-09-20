package cn.xpbootcamp.locker;

import java.util.List;

public class PrimaryLockerRobot extends AbstractRobot {

    public PrimaryLockerRobot(List<Locker> list) {
        super(list,StoreType.MEDIUM);
    }

    public Ticket save(Bag bag) {
        for (Locker locker: super.getLockers()) {
            if (locker.currentCapacity() > 0){
                return locker.save(bag);
            }
        }
        throw new LockerIsFullException();
    }


}
