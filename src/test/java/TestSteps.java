import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

public class TestSteps extends BaseClass{
    static Board actualBoard;
    static ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public static int deleteMyBoard(String boardId) throws JsonProcessingException {
        Board toDelete = new Board(key, token);
        int actualResponse =
                RequestClient.requestBuilder(BaseUrl)
                        .basePath("1/boards/" + boardId)
                        .body(toDelete)
                        .when()
                        .delete()
                        .then().extract().statusCode();
        return actualResponse;

    }
    public static Board createNewBoard(Board newBoard) throws JsonProcessingException {
        String response = RequestClient.requestBuilder(BaseUrl)
                .basePath("1/boards/")
                .body(newBoard)
                .when()
                .post()
                .then().extract().asString();
        actualBoard =  objectMapper.readValue(response, Board.class);
       return actualBoard;
    }
    public static Board checkBoardInfo(String boardId) throws JsonProcessingException {
        Board toUpdate = new Board(key, token);
        String response = RequestClient.requestBuilder(BaseUrl)
                .basePath("1/boards/" + boardId)
                .body(toUpdate)
                .when()
                .get()
                .then().extract().response().prettyPrint();
        actualBoard = objectMapper.readValue(response, Board.class);
        return actualBoard;
    }
    public static Board updateBoardInfo(String boardId) throws JsonProcessingException {
        String response = RequestClient.requestBuilder(BaseUrl)
                .basePath("1/boards/" + boardId)
                .body(new Board("NewName", key, token))
                .when()
                .put()
                .then().extract().response().prettyPrint();
        actualBoard = objectMapper.readValue(response, Board.class);
        return actualBoard;
    }
}
