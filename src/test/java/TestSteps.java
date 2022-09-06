import org.testng.Assert;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TestSteps extends BaseTest {

   public void deleteMyBoard(String boardId) throws IOException {
       int actualCode = restApiClient.deleteBoard(getValue("baseUrl"), getValue("endPoint"), boardId, getValue("key"), getValue("token"));
       Assert.assertEquals(actualCode,200);
   }

   public Board createNewBoard() throws IOException {
       actualBoard = restApiClient.createBoard(getValue("baseUrl"), getValue("endPoint"), getValue("name"), getValue("key"), getValue("token"));
       Board expectedBoard = new Board(getValue("name"), getValue("key"), getValue("token"));
       Assert.assertEquals(actualBoard, expectedBoard);
       return actualBoard;
   }

  public void checkBoardInfo(String boardId) throws IOException {
      actualBoard = restApiClient.checkBoard(getValue("baseUrl"), getValue("endPoint"), boardId, getValue("key"), getValue("token"));
      Board expectedBoard = new Board(getValue("name"), getValue("key"), getValue("token"));
      Assert.assertEquals(actualBoard, expectedBoard);
  }

  public void readBoardInfo(String boardId) throws IOException {
      Board expectedBoard = new Board(getValue("newName"), getValue("key"), getValue("token"));
      actualBoard = restApiClient.updateBoard(getValue("baseUrl"), getValue("endPoint"), boardId, getValue("newName"), getValue("key"), getValue("token"));
      Assert.assertEquals(actualBoard, expectedBoard);
      Assert.assertEquals(actualBoard.getName(), getValue("newName"));

  }
}
