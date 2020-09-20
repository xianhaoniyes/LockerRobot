package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class SuperLockerRobotTest {

    @Test
    public void should_return_robot_when_configure_robot_given_two_l_lockers(){

        Locker lockerA = new Locker(1,StoreType.LARGE);
        Locker lockerB = new Locker(1, StoreType.LARGE);

        SuperLockerRobot robot = new SuperLockerRobot(Arrays.asList(lockerA,lockerB));

        Assert.assertTrue(robot instanceof  SuperLockerRobot);

    }
}
