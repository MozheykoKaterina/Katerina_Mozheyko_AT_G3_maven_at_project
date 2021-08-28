package remote;

import gherkin.deps.com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;

public class HttpPostMy {
    
    public void search(Search search) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(fromGSON(search)));
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
    
    public static String fromGSON(Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }
    
    public static void main(String[] args) throws URISyntaxException, IOException {
        HttpPostMy httpPostMy = new HttpPostMy();
        Search search = new Search("", false);
        httpPostMy.search(search);
    }
}