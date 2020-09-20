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

    @Test(expected = IncorrectLockerType.class)
    public void should_throw_IncorrectLockerType_when_configure_robot_given_two_s_lockers(){

        Locker lockerA = new Locker(1,StoreType.SMALL);
        Locker lockerB = new Locker(1, StoreType.SMALL);

        new SuperLockerRobot(Arrays.asList(lockerA,lockerB));

    }


    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_bag_given_1st_has_larger_vacancy_ratio(){

        Locker firstLocker = new Locker(3,StoreType.LARGE);
        Locker secondLocker = new Locker(2,StoreType.LARGE);
        firstLocker.save(new Bag());
        secondLocker.save(new Bag());
        SuperLockerRobot robot = new SuperLockerRobot(Arrays.asList(firstLocker,secondLocker));

        Bag  bag = new Bag();
        Ticket ticket = robot.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, firstLocker.pickupBy(ticket));
    }
}
