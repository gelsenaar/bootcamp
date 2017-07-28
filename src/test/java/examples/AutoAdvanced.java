package examples;

public class AutoAdvanced {

    public String brand;
    public int force;
    public int rpm;

    public AutoAdvanced(String brand, int carForce, int carRpm) {
        this.brand = brand;
        this.force = carForce;
        this.rpm = carRpm;
    }

    public void readyToDrive() {
        System.out.println("Car is ready to drive");
    }

    public void printBrand() {
        System.out.println("Brand of the car is: " + brand);
    }

    public void calculateTorque() {
        int carTorque = (force * 5252)/rpm;
        System.out.println("The torque of the car is: " + carTorque);
    }

}
