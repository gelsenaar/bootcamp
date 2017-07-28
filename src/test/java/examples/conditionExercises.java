package examples;

import org.testng.annotations.Test;

/**
 * Created by Gerrit Elsenaar on 20-7-2017.
 */
public class conditionExercises {

    @Test
    public void ageChecker() {
        int givenAge1 = 12;
        int givenAge2 = 21;
        int givenAge3 = 64;
        int givenAge4 = 65;

        bootcampAgeChecker(givenAge1);
        bootcampAgeChecker(givenAge2);
        bootcampAgeChecker(givenAge3);
        bootcampAgeChecker(givenAge4);

    }

    public void bootcampAgeChecker(int age) {

        if (age > 21 && age < 65)
            System.out.println("Deelnemer toegelaten");
        else if (age > 64)
            System.out.println("Check bij manager");
        else
            System.out.println("Deelnemer is te jong");

    }
}
