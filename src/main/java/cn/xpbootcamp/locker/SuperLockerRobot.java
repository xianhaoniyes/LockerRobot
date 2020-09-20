package cn.xpbootcamp.locker;

import java.util.List;

public class SuperLockerRobot {

    private List<Locker> lockers;

    public SuperLockerRobot(List<Locker> list) {

        for (Locker locker:list) {
            if (locker.getType()!=StoreType.LARGE)
                throw new IncorrectLockerType();
        }
        this.lockers = list;
    }

    public Ticket save(Bag bag) {
        Locker lockerMax = lockers.get(0);
        for (Locker locker: lockers) {
            if (locker.vacancyRatio() > lockerMax.vacancyRatio()){
                lockerMax = locker;
            }
        }
        return lockerMax.save(bag);
    }
}
