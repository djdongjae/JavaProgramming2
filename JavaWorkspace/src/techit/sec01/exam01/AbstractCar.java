package techit.sec01.exam01;

public abstract class AbstractCar implements CarInterface {
    protected int velocity;
    @Override
    public void brake() {
        if(this.velocity < 0 ) this.velocity = 0;
    }
}
