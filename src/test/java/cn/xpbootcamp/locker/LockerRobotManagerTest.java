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

    @Test(expected = IncorrectLockerTypeException.class)
    public void should_throw_IncorrectLockerTypeException_when_configure_manager_given_one_m_lockers_one_primary_robot_one_super_robot(){

        Locker locker = new Locker(1,StoreType.MEDIUM);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, StoreType.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1,StoreType.LARGE)));

        LockerRobotManager manager = new LockerRobotManager(Arrays.asList(locker,primaryLockerRobot,superLockerRobot));
    }

    @Test
    public void should_save_in_locker_and_return_ticket_when_save_bag_given_manager_has_capacity(){
        Locker locker = new Locker(1,StoreType.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, StoreType.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1,StoreType.LARGE)));
        LockerRobotManager manager = new LockerRobotManager(Arrays.asList(locker,primaryLockerRobot,superLockerRobot));

        Ticket ticket = manager.save(new Bag());

        Assert.assertNotNull(ticket);

    }

    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_save_bag_given_lockers_are_full(){
        Locker locker = new Locker(1,StoreType.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, StoreType.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1,StoreType.LARGE)));
        LockerRobotManager manager = new LockerRobotManager(Arrays.asList(locker,primaryLockerRobot,superLockerRobot));
        manager.save(new Bag());
        manager.save(new Bag());
        manager.save(new Bag());

        manager.save(new Bag());
    }


    @Test
    public void should_return_bag_given_valid_ticket(){

        Locker locker = new Locker(1,StoreType.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, StoreType.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1,StoreType.LARGE)));
        LockerRobotManager manager = new LockerRobotManager(Arrays.asList(locker,primaryLockerRobot,superLockerRobot));
        Bag bag = new Bag();
        Ticket ticket = manager.save(bag);

        Bag returnedBag = manager.pickupBy(ticket);

        Assert.assertSame(bag,returnedBag);

    }


    @Test(expected =InvalidTicketException.class)
    public void should_throw_InvalidTicketException_when_pick_up_bag_given_an_invalid_ticket(){

        Locker locker = new Locker(1,StoreType.SMALL);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1, StoreType.MEDIUM)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(new Locker(1,StoreType.LARGE)));
        LockerRobotManager manager = new LockerRobotManager(Arrays.asList(locker,primaryLockerRobot,superLockerRobot));

        manager.pickupBy(new Ticket(StoreType.SMALL));

    }





}
