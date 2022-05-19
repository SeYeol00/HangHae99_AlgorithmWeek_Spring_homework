import java.util.UUID;

public class Taxi extends transport {

    static int extraMoney = 1500;// 추가 요금

    static int basicDis = 3;// 기본 거리(키로수)

    private String taxiName;

    private int nowSpeed;

    private int oilVolume;

    private String state;

    private int basicCost;

    private int distanceCost;

    private int basicDistatnce;

    private int destinationDistatnce;

    private String destination;

    public Taxi(int oilVolume, int basicCost,
            int destinationDistatnce, String destination) {
        this.taxiName = UUID.randomUUID().toString();
        this.nowSpeed = 0;
        this.oilVolume = oilVolume;
        this.state = "일반";
        this.basicCost = basicCost;
        this.distanceCost = extraMoney;
        this.basicDistatnce = basicDis;
        this.destinationDistatnce = destinationDistatnce;
        this.destination = destination;

    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDestinationDistatnce() {
        return destinationDistatnce;
    }

    public void setDestinationDistatnce(int destinationDistatnce) {
        this.destinationDistatnce = destinationDistatnce;
    }

    public int getBasicDistatnce() {
        return basicDistatnce;
    }

    public void setBasicDistatnce(int basicDistatnce) {
        this.basicDistatnce = basicDistatnce;
    }

    public int getDistanceCost() {
        return distanceCost;
    }

    public void setDistanceCost(int distanceCost) {
        this.distanceCost = distanceCost;
    }

    public int getBasicCost() {
        return basicCost;
    }

    public void setBasicCost(int basicCost) {
        this.basicCost = basicCost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getOilVolume() {
        return oilVolume;
    }

    public void setOilVolume(int oilVolume) {
        this.oilVolume = oilVolume;
    }

    public int getNowSpeed() {
        return nowSpeed;
    }

    public void setNowSpeed(int nowSpeed) {
        this.nowSpeed = nowSpeed;
    }

    public String getTaxiName() {
        return taxiName;
    }

    public void setTaxiName(String taxiName) {
        this.taxiName = taxiName;
    }

    @Override
    public void drive() {
        if (this.getOilVolume() < 10) {
            System.out.println("운행불가");
        } else {
            setOilVolume(getOilVolume() - 5);
            this.setState("일반");
            System.out.println("일반으로 운행시작합니다.");
        }

    }

    @Override
    public void plusSpeed(int newSpeed) {
        if (this.getOilVolume() > 10) {
            this.setOilVolume(getOilVolume() - 10);
            int getNowSpeed = this.getNowSpeed() + newSpeed;
            this.setNowSpeed(getNowSpeed);
        } else {
            System.out.println("주유량을 확인하세요");
        }

    }

    @Override
    public void minusSpeed(int newSpeed) {
        if (this.getOilVolume() > 10) {
            this.setOilVolume(getOilVolume() - 10);
            int minus = newSpeed * -1;
            int getNowSpeed = getNowSpeed() + minus;
            this.setNowSpeed(getNowSpeed);
        } else {
            System.out.println("주유량을 확인하세요");
        }

    }

    @Override
    public void passengerRide(int addition) {
        if (this.getState() == "일반") {
            setState("운행 중");
        } else {
            System.out.println("운행 중이므로 탑승 불가");
        }

    }

    public int calculate() {
        int calculation = 0;

        if (this.getDestinationDistatnce() > this.getBasicDistatnce()) {
            calculation = this.getBasicCost() + this.getDistanceCost();
        } else {
            calculation = this.getBasicCost();
        }
        System.out.println("요금은 " + calculation + "입니다.");
        return calculation;
    }

}
