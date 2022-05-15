public abstract class transport {
    public String nowSpeed;

    public int oilVolume;

    public String state;

    public int basicCost;

    public abstract void drive();

    public abstract void plusSpeed(int newSpeed);

    public abstract void minusSpeed(int newSpeed);

    public abstract void passengerRide(int addition);
}
