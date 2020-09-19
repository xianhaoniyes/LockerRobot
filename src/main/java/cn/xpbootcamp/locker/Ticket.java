package cn.xpbootcamp.locker;

public class Ticket {

    private StoreType type;

    public Ticket(StoreType type){
        this.type = type;
    }

    public StoreType getType(){
        return this.type;
    }

}
