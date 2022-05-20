//1 - Pacote
package petstore;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 2- Bibliotecas
public class Pet {
    //3.1 Atributos
    String uri = "https://petstore.swagger.io/v2/pet";

    //3.2 Métudos e Funções

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    // Incluir - Create - Post
    @Test // identifica o métudo ou função  como um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        //Sintaxe Gherkin

        given()
                .contentType("application/json")// comum em API REST
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
        ;

    }
}
