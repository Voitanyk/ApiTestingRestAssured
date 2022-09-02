import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTest extends Properties {
    TestSteps testSteps = new TestSteps();
    Properties properties = new Properties();
    Board actualBoard;
    @AfterMethod
    public void deleteBoardAfterTest() throws IOException {
    int statusCode = testSteps.deleteMyBoard(actualBoard.getId());
    Assert.assertEquals(statusCode,200);
}


    @Test
    public void createBoardTest() throws IOException {
        Board expectedBoard = new Board(properties.getValue("name"), properties.getValue("key"), properties.getValue("token"));
        actualBoard = testSteps.createNewBoard();
        Assert.assertEquals(actualBoard, expectedBoard);
    }

}
