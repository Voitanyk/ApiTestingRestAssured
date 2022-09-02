import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TestSteps extends Properties {

    static Board actualBoard;
    RestApiClient restApiClient = new RestApiClient();
    Properties properties = new Properties();

   public int deleteMyBoard(String boardId) throws IOException {
       int actualCode = restApiClient.deleteBoard(properties.getValue("baseUrl"), properties.getValue("endPoint"), boardId, properties.getValue("key"), properties.getValue("token"));
       return actualCode;
   }

   public Board createNewBoard() throws IOException {
       actualBoard = restApiClient.createBoard(properties.getValue("baseUrl"), properties.getValue("endPoint"), properties.getValue("name"), properties.getValue("key"), properties.getValue("token"));
       return actualBoard;
   }

  public Board checkBoardInfo(String boardId) throws IOException {
      actualBoard = restApiClient.checkBoard(properties.getValue("baseUrl"), properties.getValue("endPoint"), boardId, properties.getValue("key"), properties.getValue("token"));
      return actualBoard;
  }

  public Board updateBoardInfo(String boardId) throws IOException {
      actualBoard = restApiClient.updateBoard(properties.getValue("baseUrl"), properties.getValue("endPoint"), boardId, properties.getValue("newName"), properties.getValue("key"), properties.getValue("token"));
      return actualBoard;
  }
}
