package json;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GSONParser {
    
    private static final String JSON = "src/test/resources/recipe.json";
    private static final String JSON_1 = "src/test/resources/recipe1.json";
    
    public void parseGSON() throws FileNotFoundException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);
        System.out.println(recipe.recipename);
    }
    
    /*public void fromGSON() throws IOException {
        Gson gson = new Gson();
        Recipe recipe = new Recipe("Borsch", new Ingredient[]{}, 120);
        System.out.println(gson.toJson(recipe));
        Files.write(Paths.get(JSON_1), gson.toJson(recipe).getBytes());
    }*/
}