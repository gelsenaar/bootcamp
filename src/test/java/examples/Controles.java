package examples;


import org.assertj.core.api.Assertions;

import org.testng.annotations.Test;
/**
 * Created by Gerrit Elsenaar on 19-7-2017.
 */
public class Controles {

    @Test
    public void checkEen() {
        String tekst1 = "Eerste tekst";
        String tekst2 = "eerste tekst";
        String tekst3 = "Eerste tekst";

        Assertions.assertThat(tekst1).as("zomaar").contains("Eerste");

    }

    @Test
    public void checkTwee() {
        boolean eerste = false;
        boolean tweede = true;

//        Assertions.assertThat(eerste).isEqualTo(tweede).toString();
        Assertions.assertThat(eerste).isEqualTo(false).toString();
    }
    @Test
    public void checkDrie() {
        int eerste = 23;
        int tweede = 23;
        String result;

        result = Assertions.assertThat(eerste).isBetween(1,22).toString();
        System.out.println(result);
    }
}
