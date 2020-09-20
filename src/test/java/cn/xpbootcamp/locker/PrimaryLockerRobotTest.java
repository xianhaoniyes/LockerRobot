package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class PrimaryLockerRobotTest {

    @Test
    public void should_return_robot_when_configure_robot_given_two_m_lockers(){

        Locker lockerA = new Locker(1,StoreType.MEDIUM);
        Locker lockerB = new Locker(1, StoreType.MEDIUM);

        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(lockerA,lockerB));

        Assert.assertTrue(robot instanceof  PrimaryLockerRobot);

    }

    @Test(expected = IncorrectLockerType.class)
    public void should_throw_IncorrectLockerType_when_configure_robot_given_two_s_lockers(){

        Locker lockerA = new Locker(1,StoreType.SMALL);
        Locker lockerB = new Locker(1, StoreType.SMALL);

        new PrimaryLockerRobot(Arrays.asList(lockerA,lockerB));



    }

}
