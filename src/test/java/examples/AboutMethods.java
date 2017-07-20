package examples;

import org.testng.annotations.Test;

/**
 * Created by Gerrit Elsenaar on 19-7-2017.
 */
public class AboutMethods {

    int first = 3;
    int second = 78;
    int third = 2;

    @Test
    public void printProduct() {

        System.out.println(multiply(first,second));
        System.out.println(division(multiply(first,second), third));
    }

    private int multiply(int first, int second) {
        return first * second;
    }

    private int division (int firstAndSecond, int third) {
        return firstAndSecond / third;
    }

}
