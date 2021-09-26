package IcnDB;

import java.util.Objects;

public class Joke {

    public int id;
    public String joke;
    public String categories;
    
    public Joke(int id, String joke, String categories) {
        this.id = id;
        this.joke = joke;
        this.categories = categories;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke1 = (Joke) o;
        return id == joke1.id && Objects.equals(joke, joke1.joke);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, joke, categories);
    }
}
