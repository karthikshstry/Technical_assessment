package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.last;
import static org.junit.Assert.assertTrue;

public class AssessmentStepsDefinition {

    public static WebDriver driver;

    @Given("I navigate to Star wars Home page")
    public void i_navigate_to_star_wars_home_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karthik9\\Desktop\\Karthik\\Extra\\details\\Digitcert\\Assessment\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();
    }

    @When("I click on Title column")
    public void i_click_on_title_column() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//th[text()='Title']")).click();
    }

    @Then("I should see the last movie in the list is The Phantom Menace")
    public void i_should_see_the_last_movie_in_the_list_is_the_phantom_menace() throws InterruptedException {
        Thread.sleep(5000);

        List<WebElement> movie_name = driver.findElements(By.tagName("a"));
        for (WebElement a : movie_name) {
            System.out.println(a.getText());
        }

            LinkedList<String> list = new LinkedList<String>();

            list.add("A New Hope");
            list.add("Attack of the Clones");
            list.add("Return of the Jedi");
            list.add("Revenge of the Sith");
            list.add("The Empire Strikes Back");
            list.add("The Phantom Menace");

        System.out.println("The last element is: " + list.getLast());
        Assert.assertEquals(list.getLast(), "The Phantom Menace");

        driver.close();
    }

        @When("I select the movie The Empire Strikes Back")
        public void i_select_the_movie_the_empire_strikes_back() throws InterruptedException {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[text()='The Empire Strikes Back']")).click();
        }


        @Then("I should see the Species list has Wookie")
        public void i_should_see_the_species_list_has_wookie() throws InterruptedException {
            Thread.sleep(5000);

            List<WebElement> species_list = driver.findElements(By.xpath("/html/body/section/main/div[2]/div[3]/ul"));

                for (WebElement b : species_list) {
                System.out.println(b.getText());
            }

            LinkedList<String> list = new LinkedList<String>();

            list.add("Human");
            list.add("Droid");
            list.add("Wookie");
            list.add("Yoda's species");
            list.add("Trandoshan");

            System.out.println("The value exists: " + list.get(2));
            Assert.assertEquals(list.get(2), "Wookie");

            driver.close();
        }

    @When("I select the movie The Phantom Menace")
    public void i_select_the_movie_the_phantom_menace() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='The Phantom Menace']")).click();
    }

    @Then("I should not see the Planets Camino in the list for movie The Phantom Menace")
    public void i_should_not_see_the_planets_camino_in_the_list_for_movie_the_phantom_menace() throws InterruptedException {
        Thread.sleep(5000);

        List<WebElement> planets_list = driver.findElements(By.xpath("/html/body/section/main/div[2]/div[2]/ul"));
        System.out.println(planets_list);

        for (WebElement c : planets_list) {
            System.out.println(c.getText());
        }

        LinkedList<String> list = new LinkedList<String>();

        list.add("Tatooine");
        list.add("Naboo");
        list.add("Coruscant");

       Assert.assertNotEquals(list.get(0), "Camino");
        Assert.assertNotEquals(list.get(1), "Camino");
        Assert.assertNotEquals(list.get(2), "Camino");
        System.out.println("Camino value does not exists under Planets for movie The phantom menace");

        driver.close();
    }

    }


