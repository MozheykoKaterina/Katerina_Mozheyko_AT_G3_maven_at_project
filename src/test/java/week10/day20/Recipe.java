package week10.day20;

import java.util.List;

public class Recipe {
    
    public String recipename;
    public List<Ingredient> ingredlist;
    public int preptime;
    
    public Recipe(String recipename, List<Ingredient> ingredlist, int preptime) {
        this.recipename = recipename;
        this.ingredlist = ingredlist;
        this.preptime = preptime;
    }
}
