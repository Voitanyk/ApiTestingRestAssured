import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestApiClient {

    public static RequestSpecification requestClient(String url) {
        return
                given()
                        .baseUri(url)
                        .contentType("application/json");
    }

    static ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public Board createBoard(String url, String endpoint, String name, String key, String token) throws JsonProcessingException {
        String response = requestClient(url)
                .basePath(endpoint)
                .body(new Board(name, key, token))
                .when()
                .post()
                .then().extract().asString();
        return objectMapper.readValue(response, Board.class);
    }

    public Board checkBoard(String url, String endpoint, String boardId, String key, String token) throws JsonProcessingException {
        String response = requestClient(url)
                .basePath(endpoint + boardId)
                .body(new Board(key, token))
                .when()
                .get()
                .then().extract().response().prettyPrint();
        return objectMapper.readValue(response, Board.class);
    }
    public Board updateBoard(String url, String endpoint, String boardId, String newName, String key, String token) throws JsonProcessingException {
        String response = requestClient(url)
                .basePath(endpoint + boardId)
                .body(new Board(newName, key, token))
                .when()
                .put()
                .then().extract().response().prettyPrint();
        return objectMapper.readValue(response, Board.class);
    }
    public int deleteBoard(String url, String endpoint, String boardId, String key, String token) throws JsonProcessingException {
        Board toDelete = new Board(key, token);
        int actualResponse =
                requestClient(url)
                        .basePath(endpoint + boardId)
                        .body(toDelete)
                        .when()
                        .delete()
                        .then().extract().statusCode();
        return actualResponse;
    }
}
