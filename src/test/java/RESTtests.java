import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RESTtests {
    ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    Board newBoard = new Board(BaseClass.name, BaseClass.key, BaseClass.token);
    Board actualBoard;

    //Before method creates a new Trello board and checks the status code 200.
    @BeforeMethod
    public void getBoardID() throws JsonProcessingException {
        String actualResponse =
                given()
                        .baseUri(BaseClass.BaseUrl)
                        .contentType("application/json")
                        .basePath("1/boards/")
                        .body(newBoard)
                        .when()
                        .post()
                        .then().extract().response().prettyPrint();
        actualBoard = objectMapper.readValue(actualResponse, Board.class);
    }

    //After method deletes the board after completed tests
    @AfterMethod
    public void deleteMyBoard() throws JsonProcessingException {
        int actualResponse =
                given()
                        .baseUri(BaseClass.BaseUrl)
                        .contentType("application/json")
                        .basePath("1/boards/" + actualBoard.getId())
                        .body(newBoard)
                        .when()
                        .delete()
                        .then().extract().statusCode();
        Assert.assertEquals(actualResponse, 200);

    }
    //The test is to get information about my Trello board, using the board ID. The test validates the name of the board.
    @Test
    public void checkMyBoard() throws JsonProcessingException {
        String actualResponse =
                given()
                        .baseUri(BaseClass.BaseUrl)
                        .contentType("application/json")
                        .basePath("1/boards/" + actualBoard.getId())
                        .body(newBoard)
                        .when()
                        .get()
                        .then().extract().response().prettyPrint();
        actualBoard = objectMapper.readValue(actualResponse, Board.class);
        Assert.assertEquals(actualBoard.getName(), BaseClass.name);
    }

    @Test
    public void updateMyBoard() throws JsonProcessingException {
        String actualResponse =
                given()
                        .baseUri(BaseClass.BaseUrl)
                        .contentType("application/json")
                        .basePath("1/boards/" + actualBoard.getId())
                        .body(new Board("newName", BaseClass.key, BaseClass.token ))
                        .when()
                        .put()
                        .then().extract().response().prettyPrint();
        actualBoard = objectMapper.readValue(actualResponse, Board.class);
        Assert.assertEquals(actualBoard.getName(), "newName");
    }
}
