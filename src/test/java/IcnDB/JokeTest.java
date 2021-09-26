package IcnDB;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JokeTest {
    
    public static final RequestSpecification REQUEST_SPECIFICATION_JOKE = new RequestSpecBuilder()
            .setBaseUri("http://api.icndb.com/jokes/random/1")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    
    //private static final String JSON = "src/test/resources/jokes.json";
    
    /*private static Joke getJokeRandom() throws FileNotFoundException {
        Gson gson = new Gson();
        Jokes jokes = gson.fromJson(new JsonReader(new FileReader(JSON)), Jokes.class);
        System.out.println("get " + jokes.jokes.stream().filter(x -> x.joke.equals(jokes)).findAny().get());
        return jokes.jokes.stream().filter(x -> x.joke.equals(jokes)).findAny().get();
    }*/
    
    
    @Test
    public void testMethod() throws FileNotFoundException {
        //String joke = "a";
        System.out.println("set: " + RestAssured
                .given()
                .spec(REQUEST_SPECIFICATION_JOKE.request())
                .post()
                .then()
                .toString());
        
        RestAssured
                .given()
                .spec(REQUEST_SPECIFICATION_JOKE.request())
                .when()
                .post()
                .then()
                .extract().body().as(Jokes.class).toString();
    }
}
