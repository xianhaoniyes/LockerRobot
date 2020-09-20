package cn.xpbootcamp.locker;

import java.util.List;

public class SuperLockerRobot extends AbstractRobot {


    public SuperLockerRobot(List<Locker> list) {
        super(list,StoreType.LARGE);
    }

    public Ticket save(Bag bag) {
        List<Locker> lockers = super.getLockers();
        Locker lockerMax = lockers.get(0);
        for (Locker locker: lockers) {
            if (locker.vacancyRatio() > lockerMax.vacancyRatio()){
                lockerMax = locker;
            }
        }
        return lockerMax.save(bag);
    }

}
