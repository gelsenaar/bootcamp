package chapterNine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

/*
Lineair testgeval. Maakt geen gebruik van TestShopScenario
 */

public class DeleteWishListTest {

    @Test
    public void deleteWishList() throws InterruptedException {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");

        // Click on the login link
        driver.findElement(By.className("login")).click();

        // Enter username
        driver.findElement(By.id("email")).sendKeys("gerrit@elsenaar.com");

        // Enter password
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");

        // Click the Log in button
        driver.findElement(By.id("SubmitLogin")).click();

        //Click the
        driver.findElement(By.cssSelector("i.icon-heart")).click();

        //Locate the webtable.
        WebElement wishListTable = driver.findElement(By.cssSelector(".table.table-bordered"));

        //Locate rows of the webtable.
        List<WebElement> rowsTable = wishListTable.findElements(By.tagName("tr"));

        //Calculate no of rows In the webtable.
        int rowsCount = rowsTable.size();

        //get the first columns from the first row which has all the header titles
        List<WebElement> headerColumsTable = rowsTable.get(0).findElements(By.tagName("th"));

        //Calculate no of columns present
        int columsCount = headerColumsTable.size();

        //Get the index for the Name column and Delete column
        int nameColumn = -1;
        int deleteColumn = -1;
        for (int i = 0; i < headerColumsTable.size(); i++) {
            if (headerColumsTable.get(i).getText().equals("Name")) {
                nameColumn = i;
            } else if (headerColumsTable.get(i).getText().equals("Delete")) {
                deleteColumn = i;
            }
        }

        //Find the correct row, SKIP HEADER ROW
        String listToDelete = "Feel the pain";

        //----------Method building
        Assertions.assertThat(checkWebTableForName(rowsTable, nameColumn, listToDelete))
                .as("Check if name can be found in the webtable")
                .isTrue();
        //----------Mehtod building

        boolean wishListFound = false;
        for (int i = 1; i < rowsTable.size(); i++) {
            List<WebElement> wishListColumn = rowsTable.get(i).findElements(By.tagName("td"));
            /*for(WebElement webElement : wishListColumn ){
                System.out.println(webElement.getText());
            }
            */
            if (wishListColumn.get(nameColumn).getText().equals(listToDelete)) {
                wishListColumn.get(deleteColumn).findElement(By.cssSelector("a.icon")).click();
                wishListFound = true;
                break;
            }
        }

        Assertions.assertThat(wishListFound).as("Could not find the given wishList").isTrue();

        try {
            //Wait 10 seconds till alert is present
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Accepting alert.
            alert.accept();
            System.out.println("Accepted the alert successfully.");
        } catch (Throwable e) {
            System.err.println("Error came while waiting for the alert popup. " + e.getMessage());
        }


        //Refresh WebTable, element has become stale
        Thread.sleep(500);
        wishListTable = driver.findElement(By.cssSelector(".table.table-bordered"));
        rowsTable = wishListTable.findElements(By.tagName("tr"));

        //Start building a method from the code
        Assertions.assertThat(checkWebTableForName(rowsTable, nameColumn, listToDelete))
                .as("Check if delete was succesfull")
                .isFalse();

        driver.findElement(By.cssSelector("input#name")).sendKeys(listToDelete);
        driver.findElement(By.cssSelector("button#submitWishlist")).click();

        //Refresh WebTable, element has become stale
        Thread.sleep(500);
        wishListTable = driver.findElement(By.cssSelector(".table.table-bordered"));
        rowsTable = wishListTable.findElements(By.tagName("tr"));

        //----------Method building
        Assertions.assertThat(checkWebTableForName(rowsTable, nameColumn, listToDelete))
                .as("Check if adding the list back was succesfull")
                .isTrue();
        //----------Mehtod building

        driver.quit();
    }


    public boolean checkWebTableForName(List<WebElement> webTable, int column, String name){
        for(int i = 1; i < webTable.size(); i++){
            List<WebElement> wishListColumn = webTable.get(i).findElements(By.tagName("td"));

            if (wishListColumn.get(column).getText().equals(name)){
                return true;
            }
        }
        return false;
    }
}

