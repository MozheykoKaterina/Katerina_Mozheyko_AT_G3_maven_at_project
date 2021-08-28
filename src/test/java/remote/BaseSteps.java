package remote;

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

public class BaseSteps {
    
    public static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri("http://178.124.206.46:8001/app/ws/")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    
    private static final String JSON = "src/test/resources/users.json";
    
    private static User getUser(String name) throws FileNotFoundException {
        Gson gson = new Gson();
        Data data = gson.fromJson(new JsonReader(new FileReader(JSON)), Data.class);
        System.out.println("get " + data.data.stream().filter(x -> x.username.equals(name)).findAny().get());
        return data.data.stream().filter(x -> x.username.equals(name)).findAny().get();
    }
    
    private static User getUserRealName(String name) throws FileNotFoundException {
        Gson gson = new Gson();
        Data data = gson.fromJson(new JsonReader(new FileReader(JSON)), Data.class);
        data.data.stream().filter(x -> x.realname.contains("Berta")).forEach(System.out::println);
        return data.data.stream().filter(x -> x.realname.contains(name)).findAny().get();
    }
    
    @Test
    public void testMethod() throws FileNotFoundException {
        String name = "a";
        System.out.println("set: " + RestAssured
                .given()
                .spec(BaseSteps.REQUEST_SPECIFICATION)
                .body(new Search(name, true))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class));
        
                RestAssured
                .given()
                .spec(BaseSteps.REQUEST_SPECIFICATION)
                .body(new Search(name, true))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class).equals(BaseSteps.getUser(name));
    }
    
    @Test
    public void testMethodUserName() throws FileNotFoundException {
        String name = "Berta";
        System.out.println("set: " + RestAssured
                .given()
                .spec(BaseSteps.REQUEST_SPECIFICATION)
                .body(new Search(name, true))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class));
        
        RestAssured
                .given()
                .spec(BaseSteps.REQUEST_SPECIFICATION)
                .body(new Search(name, true))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class).equals(BaseSteps.getUserRealName(name));
    }
}