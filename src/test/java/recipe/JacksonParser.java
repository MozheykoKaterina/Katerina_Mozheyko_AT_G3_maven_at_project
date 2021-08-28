package recipe;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonParser {
    
    private static final String JSON = "src/test/resources/recipe.json";
    
    File file = new File(JSON);
    
    public void parseJackson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(file, Recipe.class);
        System.out.println(recipe.recipename);
    }
}