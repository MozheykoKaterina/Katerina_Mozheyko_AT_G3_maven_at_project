package IcnDB;

import java.util.List;
import java.util.Objects;

public class Jokes {
    
    public String success;
    public List<Joke> jokes;
    
    public Jokes(String success, List<Joke> jokes) {
        this.success = success;
        this.jokes = jokes;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jokes jokes1 = (Jokes) o;
        return Objects.equals(success, jokes1.success) && Objects.equals(jokes, jokes1.jokes);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(success, jokes);
    }
    
    @Override
    public String toString() {
        return "Jokes{" +
                "success='" + success + '\'' +
                ", jokes=" + jokes +
                '}';
    }
}