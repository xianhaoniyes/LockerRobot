package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

public class LockerTest {

    @Test
    public void should_return_ticket_when_locker_save_bag_given_locker_has_available_capacity(){
        Locker locker = new Locker(10,StoreType.SMALL);

        Ticket ticket = locker.save(new Bag());

        Assert.assertNotNull(ticket);
    }


    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_locker_save_bag_given_locker_is_full(){
        Locker locker = new Locker(1,StoreType.SMALL);

        locker.save(new Bag());
        locker.save(new Bag());
    }

    @Test
    public void should_return_bag_when_locker_pick_up_bag_given_a_valid_ticket(){
        Locker locker = new Locker(1,StoreType.SMALL);
        Bag savingBag = new Bag();
        Ticket ticket = locker.save(savingBag);

        Bag takingBag = locker.pickupBy(ticket);

        Assert.assertSame(savingBag,takingBag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_throw_InvalidTicketException_when_locker_pick_up_bag_given_an_invalid_ticket() {
        Locker locker = new Locker(1,StoreType.SMALL);
        locker.save(new Bag());

        locker.pickupBy(new Ticket(StoreType.SMALL));
    }

    @Test(expected = TypeNotMatchException.class)
    public void should_throw_TypeNotMatchException_when_pick_up_bag_given_a_ticket_with_incorrect_type(){
        Locker locker = new Locker(1,StoreType.SMALL);
        locker.save(new Bag());

        locker.pickupBy(new Ticket(StoreType.MEDIUM));

    }



}
