package examples;

public class Auto {

    public void setColor(String carColor) {
        System.out.println("The color of the car is: " + carColor);
    }

    public void setBrand(String carBrand) {
        System.out.println("The brand of the car is: " + carBrand);
    }

    public void setDoors(int carDoors) {
        System.out.println("The number of doors of the car is: " + carDoors);
    }

    public void setEngineType(String carEngineType) {
        System.out.println("The engine type of the car is: " + carEngineType);
    }

    public void calculateTorque(int carForce, int carRpm) {
        int carTorque = (carForce * 5252)/carRpm;
        System.out.println("The torque of the car is: " + carTorque);
    }
}
