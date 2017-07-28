package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class SimpleTest {

    String season = "2016";
    String driver = "max_verstappen";

    @Test
    public void doGet() {
        given().when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").then().statusCode(200);
    }

    @Test
    public void getVerstappen() {
        given().when().
                get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().assertThat().body("MRData.RaceTable.driverId", containsString("max_verstappen"));
    }

    @Test
    public void getKees() {
        given().when().
                get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().assertThat().body("MRData.RaceTable.driverId", containsString("kees"));
    }

    @Test
    public void testURLParam() {
        given().pathParam("season", "2016").pathParam("driver", "max_verstappen").
                when().get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json").
                then().statusCode(200);
    }

    @Test
    public void getVersappenNogEens() {
        given().when().
                get("http://ergast.com/api/f1/" + season + "/drivers/" + driver + "/results.json").
                then().assertThat().body("MRData.RaceTable.driverId", containsString("max_verstappen"));
    }

    @Test
    public void getHemWeer() {
        given().pathParam("season", season).pathParam("driver",driver).
                when().get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json").
                then().statusCode(200);

    }
}
