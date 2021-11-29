package validations;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static component.request.postRequest;

public class TestValidations {
    private String response;
    private JSONObject json;

    @Test
    public void simpleSimple() throws IOException {
        response = postRequest("simple-simple");
        json = new JSONObject(response);
        System.out.println(json);
    }
}
