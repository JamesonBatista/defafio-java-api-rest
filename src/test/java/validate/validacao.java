package validate;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static validate.ResponsePost.*;

public class validacao {

    /*
    Extraia a resposta do RestAssured e comece a validação,
    no Test abaixo está um exemplo do primeiro JSON sendo validado, conforme o desafio.
    Para extrair usaremos o JSONObject já incluso em suas dependências.
     */
    JSONObject json;
    JSONArray jsonArray;



    @Test
    public void validacaoJSON() throws IOException {
        Responses("simple-simple");

        json = new JSONObject(response.extract().response().asString());
        System.out.println(json);
    }
}
