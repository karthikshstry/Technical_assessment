import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;


public class APITests {

    Response response;

    @Test
      void Verify_Get_list_of_movies_and_check_if_the_movies_count_is_6() {

        response = get("https://swapi-node.now.sh/api/films");

        System.out.println("Response : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());

        int count = response.jsonPath().get("count");

        Assert.assertEquals(count, 6, "Count received from Response");

    }

    @Test
    void Verify_Get_3rd_movie_and_director_is_RichardMarquand() {

        response = get("https://swapi-node.now.sh/api/films/3");

        System.out.println("Response : " + response.asString());

        String director = response.jsonPath().get("fields.director");
        System.out.println("Director received from Response is " + director);
        Assert.assertEquals(director, "Richard Marquand", "Correct director name received in the Response");

    }

    @Test
    void Verify_Get_5th_movie_and_Producers_are_not_GaryKurtz_GeorgeLucas() {

        Response response = get("https://swapi-node.now.sh/api/films/5");

        System.out.println("Response : " + response.asString());

        JsonPath jsonPathEvaluator = response.jsonPath();
        String producer = jsonPathEvaluator.get("fields.producer");
        System.out.println("Producer received from Response is " + producer);
        Assert.assertNotEquals(producer, "Gary Kurtz, George Lucas", "Producers are not ‘Gary Kurtz, George Lucas'");

    }
}


