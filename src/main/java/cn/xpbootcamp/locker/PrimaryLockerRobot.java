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
}
