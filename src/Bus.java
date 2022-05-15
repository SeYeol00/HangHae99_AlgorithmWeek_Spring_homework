import java.util.UUID; //UUIT는 고유값을 생성해준다. 기억하기

public class Bus extends transport {
    private String busName;

    private int nowSpeed;

    private int oilVolume;

    private String state;

    private int basicCost;

    private int maxPassenger;

    private int nowPassenger;

    public Bus(String busName, int oilVolume, int basicCost, int maxPassenger) {
        this.busName = UUID.randomUUID().toString();
        this.nowSpeed = 0;
        this.oilVolume = oilVolume;
        this.state = "운행";
        this.basicCost = basicCost;
        this.maxPassenger = maxPassenger;
        this.nowPassenger = 0;
    }

    public String getBusName() {
        return busName;
    }

    public int getNowPassenger() {
        return nowPassenger;
    }

    public void setNowPassenger(int addition) {
        this.nowPassenger = getNowPassenger() + addition;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
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

    public void setNowSpeed(int addition) {
        this.nowSpeed = getNowSpeed() + addition;
    }

    @Override
    public void plusSpeed(int newSpeed) {
        if (getOilVolume() > 10) {

            setNowSpeed(newSpeed);
        } else {
            System.out.println("주유량을 확인하세요");
        }

    }

    @Override
    public void minusSpeed(int newSpeed) {
        if (getOilVolume() > 10) {
            int minus = newSpeed * -1;
            setNowSpeed(minus);
        } else {
            System.out.println("주유량을 확인하세요");
        }

    }

    @Override
    public void passengerRide(int addition) {
        if (this.getNowPassenger() >= this.getMaxPassenger() || this.getState().equals("차고지행")) {
            System.out.println("사람이 더 들어 갈 수 없습니다.");
        } else if (this.getNowPassenger() < this.getMaxPassenger() && this.getState().equals("운행")) {
            this.setNowPassenger(addition);
            System.out.println("탑승 완료");
        }
    }

    @Override
    public void drive() {
        if (this.getOilVolume() < 10) {
            System.out.println("주유가 필요하다.");
        } else {
            this.setState("운행");
            System.out.println("운행시작");
        }
    }

    public void changeBusState() {
        if (this.getState().equals("운행") || this.getOilVolume() < 10) {
            System.out.println("주유가 필요하다.");
            this.setState("차고지행");
        }

    }
}
