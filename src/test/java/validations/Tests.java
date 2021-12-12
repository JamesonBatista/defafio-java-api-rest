package validations;

import io.cucumber.messages.JSON;
import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static component.request.postRequest;

public class Tests {
    private String response;
    private JSONObject json;

    @Test
    public void simpleSimple() throws IOException {
        response = postRequest("simple-simple").extract().asString();
        json = new JSONObject(response);

        String name = json.getJSONObject("user").get("name").toString();
        Assert.assertEquals(name, "Thompson");

        Object city = json.getJSONObject("user").getJSONObject("address").get("city");
//        System.out.println(city);

    }

}
