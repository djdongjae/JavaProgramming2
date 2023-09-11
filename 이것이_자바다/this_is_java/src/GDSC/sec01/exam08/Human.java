package GDSC.sec01.exam08;

public class Human {
}

interface Hero {
    public abstract void attack();
}

class IronMan extends Human implements Hero {
    @Override
    public void attack() {};
    void rocket() {};
}
