package component;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class responseRequisition {


    public static ValidatableResponse postReturn(String name) throws IOException {
        RestAssured.baseURI = "https://reqres.in/api/users/7"; // Chamada RestAssured não precisa ser alterada
        return  given()
                .contentType(ContentType.JSON)
                .body(new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/" + name + ".json"))))
                .when()
                .post().then();
    }
}
