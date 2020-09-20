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

    @Test(expected = IncorrectLockerTypeException.class)
    public void should_throw_IncorrectLockerType_when_configure_robot_given_two_s_lockers(){

        Locker lockerA = new Locker(1,StoreType.SMALL);
        Locker lockerB = new Locker(1, StoreType.SMALL);

        new PrimaryLockerRobot(Arrays.asList(lockerA,lockerB));

    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_bag_given_1st_has_capacity(){

        Locker firstLocker = new Locker(1,StoreType.MEDIUM);
        Locker secondLocker = new Locker(1,StoreType.MEDIUM);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstLocker,secondLocker));

        Bag  bag = new Bag();
        Ticket ticket = robot.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, firstLocker.pickupBy(ticket));
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_bag_given_1st_is_full_and_2st_had_capacity(){

        Locker firstLocker = new Locker(1,StoreType.MEDIUM);
        Locker secondLocker = new Locker(1,StoreType.MEDIUM);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstLocker,secondLocker));
        robot.save(new Bag());
        Bag bag = new Bag();

        Ticket ticket = robot.save(bag);

        Assert.assertNotNull(ticket);
        Assert.assertSame(bag, secondLocker.pickupBy(ticket));
    }

    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_locker_save_bag_given_lockers_are_full(){

        Locker firstLocker = new Locker(1,StoreType.MEDIUM);
        Locker secondLocker = new Locker(1,StoreType.MEDIUM);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstLocker,secondLocker));
        robot.save(new Bag());
        robot.save(new Bag());

        robot.save(new Bag());
    }

    @Test
    public void should_return_bag_given_valid_ticket(){

        PrimaryLockerRobot robot = new PrimaryLockerRobot
                (Arrays.asList(new Locker(1,StoreType.MEDIUM),new Locker(1,StoreType.MEDIUM)));
        Bag bag = new Bag();
        Ticket ticket = robot.save(bag);

        Bag returnedBag = robot.pickupBy(ticket);

        Assert.assertSame(bag,returnedBag);

    }

    @Test(expected = InvalidTicketException.class)
    public void should_throw_InvalidTicketException_when_pickup_bag_given_invalid_ticket(){

        PrimaryLockerRobot robot = new PrimaryLockerRobot
                (Arrays.asList(new Locker(1,StoreType.MEDIUM),new Locker(1,StoreType.MEDIUM)));
        Ticket ticket = new Ticket(StoreType.MEDIUM);

        robot.pickupBy(ticket);

    }


    @Test(expected =TicketTypeNotMatchException.class)
    public void should_throw_TicketTypeNotMatchException_when_pick_up_bag_given_a_ticket_with_incorrect_type(){

        PrimaryLockerRobot robot = new PrimaryLockerRobot
                (Arrays.asList(new Locker(1,StoreType.MEDIUM),new Locker(1,StoreType.MEDIUM)));

        robot.pickupBy(new Ticket(StoreType.SMALL));

    }





}
