package validations;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static component.request.postRequest;

public class Tests {
    private String response;
    private JSONObject json;

    @Test
    public void simpleSimple() throws IOException {
        response = postRequest("simple-simple");
        json = new JSONObject(response);
        System.out.println(json);
    }
}
