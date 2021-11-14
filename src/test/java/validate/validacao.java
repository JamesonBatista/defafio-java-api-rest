package validate;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class validacao {

    /*
    Extraia a resposta do RestAssured e comece a validação,
    no Test abaixo está um exemplo do primeiro JSON sendo validado, conforme o desafio.
    Para extrair usaremos o JSONObject já incluso em suas dependências.
     */
    JSONObject json;
    JSONArray jsonArray;
    ValidatableResponse response;

    private static String body;

    @BeforeClass
    public static void initRest() {
        RestAssured.baseURI = "https://reqres.in/api/users/7"; // Chamada RestAssured não precisa ser alterada

    }

    // Aqui será onde você irá passar o nome do JSON de sua validação conforme o Test abaixo.
    public String JSON(String nameJSON) throws IOException {
        return body = new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/" + nameJSON + ".json")));
    }

    @Test
    public void validacaoJSON() throws IOException {
        response = given()
                .contentType(ContentType.JSON)
                .body(JSON("camada-pre-sal"))
                .when()
                .post().then();

        json = new JSONObject(response.extract().response().asString());

        jsonArray = json.getJSONObject("user-info").optJSONArray("address");
        for (Object x : jsonArray) {
            json = new JSONObject(x.toString());
            jsonArray = json.getJSONObject("primary-address").getJSONArray("house");

            for (Object a : jsonArray) {
                json = new JSONObject(a.toString());
                jsonArray = json.getJSONObject("room").getJSONArray("bed");

                for (Object b : jsonArray) {
                    json = new JSONObject(b.toString());
                    jsonArray = json.getJSONObject("sanders").optJSONArray("airPlane");

                    for (Object c : jsonArray) {
                        json = new JSONObject(c.toString());

                        if (json.has("Brooks"))
                            jsonArray = json.getJSONArray("Brooks");
                        for (Object d : jsonArray) {
                            json = new JSONObject(d.toString());
                            if (json.has("books"))
                                jsonArray = json.getJSONArray("books");
                            for (Object e : jsonArray) {
                                json = new JSONObject(e.toString());

                                if (json.has("result-final"))
                                    System.out.println(json.getJSONObject("result-final").get("value"));
                            }
                        }
                    }
                }
            }
        }
    }
}
