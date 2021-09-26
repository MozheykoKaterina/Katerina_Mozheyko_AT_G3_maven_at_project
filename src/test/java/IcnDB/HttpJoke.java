package IcnDB;

import gherkin.deps.com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class HttpJoke {
    
    public static String fromGSON(Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }
    
    public void searchJokeRandom(Search search) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://api.icndb.com/jokes/random");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(fromGSON(search)));
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
    
    public void searchJokeRandomMultiple(Search search) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://api.icndb.com/jokes/random/3");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(fromGSON(search)));
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
    
    public void renameMainCharater(Search search) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://api.icndb.com/jokes/random?firstName=John&lastName=Doe");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(fromGSON(search)));
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
    
    @Test
    public void searchRandom() throws URISyntaxException, IOException {
        HttpJoke joke = new HttpJoke();
        Search search = new Search("", false);
        joke.searchJokeRandom(search);
    }
    
    @Test
    public void searchRandomMultiple() throws URISyntaxException, IOException {
        HttpJoke joke = new HttpJoke();
        Search search = new Search("", false);
        joke.searchJokeRandomMultiple(search);
    }
    
    @Test
    public void rename() throws URISyntaxException, IOException {
        HttpJoke joke = new HttpJoke();
        Search search = new Search("", false);
        joke.renameMainCharater(search);
    }
}