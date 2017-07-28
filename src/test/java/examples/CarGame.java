package examples;

import org.testng.annotations.Test;

public class CarGame {

    @Test
    public void startGameOne() {
        Auto auto = new Auto();

        auto.setColor("Blue");
        auto.setBrand("Volvo");
        auto.setDoors(5);
        auto.setEngineType("Diesel");
        auto.calculateTorque(10, 5252);
    }

    @Test
    public void startGameTwo() {
        AutoAdvanced autoAdvanced = new AutoAdvanced("Volvo", 120, 2000);

        autoAdvanced.readyToDrive();
        autoAdvanced.printBrand();
        autoAdvanced.calculateTorque();
    }
}
