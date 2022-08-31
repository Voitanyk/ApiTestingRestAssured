import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstTest extends BaseClass {
    Board actualBoard;
    @AfterMethod
    public void deleteBoardAfterTest() throws JsonProcessingException {
    int statusCode = TestSteps.deleteMyBoard(actualBoard.getId());
    Assert.assertEquals(statusCode,200);
}


    @Test
    public void createBoardTest() throws JsonProcessingException {
        Board expectedBoard = new Board(name, key, token);
        actualBoard = TestSteps.createNewBoard(expectedBoard);
        Assert.assertEquals(actualBoard, expectedBoard);
    }

}
