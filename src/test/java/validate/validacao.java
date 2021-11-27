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
    static ValidatableResponse response;
    private static String body;

    @BeforeClass
    public static void initRest() throws IOException {
        RestAssured.baseURI = "https://reqres.in/api/users/7"; // Chamada RestAssured não precisa ser alterada
    }

    // Aqui será onde você irá passar o nome do JSON de sua validação conforme o Test abaixo.
    public static String JSON(String nameJSON) throws IOException {
        return body = new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/" + nameJSON + ".json")));
    }

    public static ValidatableResponse Responses(String name) throws IOException {
        return response = given()
                .contentType(ContentType.JSON)
                .body(JSON(name))
                .when()
                .post().then();
    }


    @Test
    public void validacaoJSON() throws IOException {
        Responses("simple-simple");

        json = new JSONObject(response.extract().response().asString());
        System.out.println(json);

    }
}
