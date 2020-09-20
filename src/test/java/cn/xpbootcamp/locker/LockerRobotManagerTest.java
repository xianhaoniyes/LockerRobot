package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class LockerRobotManagerTest {

    @Test
    public void should_return_manager_when_configure_manager_given_one_s_lockers_one_primary_robot_one_super_robot(){

        Locker locker = new Locker(1,StoreType.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, StoreType.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1,StoreType.LARGE)));

        LockerRobotManager manager = new LockerRobotManager(Arrays.asList(locker,primaryLockerRobot,superLockerRobot));

        Assert.assertTrue(manager instanceof  LockerRobotManager);
    }
}
